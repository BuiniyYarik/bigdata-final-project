"""
This module contains code for a big data final project.
"""
import os
import math
import warnings
from pyspark.ml.param.shared import HasInputCol, HasOutputCol, Param, TypeConverters
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
import pyspark.sql.functions as F

from pyspark.sql import SparkSession
from pyspark.sql.functions import coalesce
from pyspark.sql.types import StringType
from pyspark.ml.feature import OneHotEncoder, StringIndexer, VectorAssembler, MinMaxScaler
from pyspark.ml import Pipeline, Transformer
from pyspark.ml.classification import RandomForestClassifier, FMClassifier
from pyspark.ml.evaluation import BinaryClassificationEvaluator
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator

# Disable pylint warnings that cannot be handled
# pylint: disable=too-many-ancestors

warnings.filterwarnings("ignore", category=FutureWarning, module="pyspark.*")

HDFS_BASE_PATH = "/user/team22/project"
LOCAL_BASE_PATH = "~/bigdata-final-project/temp"
MODEL_PATH = HDFS_BASE_PATH + "/temp/models"
DATA_PATH = HDFS_BASE_PATH + "/temp/data"
OUTPUT_PATH = HDFS_BASE_PATH + "/temp/output"


class TimeTransformer(Transformer, HasInputCol, HasOutputCol,
                      DefaultParamsReadable, DefaultParamsWritable):
    """
    Custom transformer for time transformation.
    """

    def __init__(self, input_col="input", output_col="output"):
        super().__init__()
        self.input_col = Param(self, "input_col", "input column name.", TypeConverters.toString)
        self.output_col = Param(self, "output_col", "output column name.", TypeConverters.toString)
        self._setDefault(input_col=None, output_col=None)
        self.set_params(input_col=input_col, output_col=output_col)
        self.set_coef()

    def set_coef(self, coef=12.0):
        """
        Set coefficient for transformation.
        """
        self.coef = coef
        return self

    def set_params(self, input_col="input", output_col="output"):
        """
        Set parameters for transformation.
        """
        self._set(input_col=input_col, output_col=output_col)

    def get_input_col(self):
        """
        Get input column.
        """
        return self.getOrDefault(self.input_col)

    def get_output_col(self):
        """
        Get output column.
        """
        return self.getOrDefault(self.output_col)

    def _transform(self, dataset):
        # Build output columns for sine and cosine
        input_col = self.get_input_col()
        output_col = self.get_output_col()
        output_col_cos = output_col + "_cos"
        output_col_sin = output_col + "_sin"

        transform_udf = F.udf(lambda x: str(2*math.pi*int(x)/self.coef), StringType())
        return dataset.withColumn(output_col_cos, F.cos(transform_udf(input_col))) \
                      .withColumn(output_col_sin, F.sin(transform_udf(input_col)))


def fillna_mean(dataset, include=None):
    """
    Fill NA values with mean.
    """
    if include is None:
        include = set()
    means = dataset.agg(*(F.mean(x).alias(x) for x in dataset.columns if x in include))
    return dataset.fillna(means.first().asDict())


def fillna_mode(dataset, column):
    """
    Fill NA values with mode.
    """
    mode = dataset.groupby(column).count() \
                                  .orderBy('count', ascending=False) \
                                  .select(column) \
                                  .collect()[1][column]
    return dataset.na.fill(value=mode, subset=[column])


def run(command):
    """
    Run a command.
    """
    return os.popen(command).read()


def handle_nulls(dataset):
    """
    Handle null values in DataFrame.
    """
    dataset_out = dataset.dropna(subset=["crselapsedtime", 'divairportlandings'])
    dataset_out = (dataset_out.withColumn(
        "deptime",
        coalesce(dataset_out.deptime, dataset_out.crsdeptime))
    )
    dataset_out = (dataset_out.withColumn(
        "arrtime",
        coalesce(dataset_out.arrtime, dataset_out.crsarrtime))
    )
    dataset_out = (dataset_out.withColumn(
        "actualelapsedtime",
        coalesce(dataset_out.actualelapsedtime, dataset_out.crselapsedtime))
    )
    dataset_out = fillna_mean(
        dataset_out,
        {'taxiout', 'wheelsoff', 'wheelson', 'taxiin'}
    )
    dataset_out = fillna_mode(dataset_out, 'tail_number')
    dataset_out = dataset_out.withColumn(
        'tmp',
        (dataset_out['actualelapsedtime'] -
         dataset_out['taxiout'] - dataset_out['taxiin'])
    )
    dataset_out = dataset_out.withColumn(
        "airtime",
        coalesce(dataset_out.airtime, dataset_out.tmp)
    ).drop('tmp')
    dataset_out = dataset_out.na.fill(
        value=0,
        subset=["depdelayminutes", 'depdelay', "arrdelayminutes",
                'arrdelay', 'arrivaldelaygroups', 'departuredelaygroups']
    )
    dataset_out = dataset_out.na.fill(value=False, subset=['depdel15', 'arrdel15'])
    return dataset_out


def sample_data(dataframe, label='cancelled'):
    """
    Sample data.
    """
    major_df = dataframe.filter(F.col(label) == 'false')
    minor_df = dataframe.filter(F.col(label) == 'true')
    result_frac = minor_df.count() / major_df.count()
    dataframe_sampled = dataframe.sampleBy(label, fractions={False: result_frac, True: 1}, seed=123)
    return dataframe_sampled


print("Initializing Spark session...")

TEAM = 22
WAREHOUSE = HDFS_BASE_PATH + "/hive/warehouse"
spark = SparkSession.builder.appName(f"{TEAM} - spark ML").master("yarn") \
    .config("spark.executor.cores", 10).config("spark.executor.memory", "10g") \
    .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883") \
    .config("spark.sql.warehouse.dir", WAREHOUSE) \
    .config("spark.sql.avro.compression.codec", "snappy") \
    .enableHiveSupport().getOrCreate()

print("Creating dataset from Hive table...")
df = spark.sql("SELECT * FROM team22_projectdb.flights")

df = handle_nulls(df)
dataset_sampled = sample_data(df)

print("Dataset created successfully.")

numerical = ['depdelayminutes', 'depdelay', 'arrdelayminutes', 'airtime',
             'crselapsedtime', 'actualelapsedtime', 'distance', 'year',
             'flight_number_marketing_airline', 'flight_number_operating_airline',
             'originairportid', 'originairportseqid', 'origincitymarketid',
             'originstatefips', 'originwac', 'destairportid', 'destairportseqid',
             'destcitymarketid', 'deststatefips', 'destwac',
             'departuredelaygroups', 'taxiout', 'taxiin', 'arrdelay',
             'arrivaldelaygroups', 'distancegroup']
cyclical = ['quarter', 'month', 'dayofmonth', 'dayofweek']
time_features = ['crsdeptime', 'deptime', 'crsarrtime', 'arrtime', 'wheelson', 'wheelsoff']
date_features = ['flightdate']
boolean_features = ['diverted', 'depdel15', 'arrdel15']
categorical_as_cont = ['origin', 'dest', 'tail_number', 'origincityname',
                       'destcityname']
categorical_ohe = ['airline', 'marketing_airline_network',
                   'operated_or_branded_code_share_partners',
                   'iata_code_marketing_airline', 'operating_airline',
                   'iata_code_operating_airline', 'originstate',
                   'originstatename', 'deststate', 'deststatename',
                   'deptimeblk', 'arrtimeblk',
                   'divairportlandings', 'dot_id_marketing_airline', 'dot_id_operating_airline']
LABEL = 'cancelled'

print("Preprocessing dataset...")
for b in boolean_features + [LABEL]:
    dataset_sampled = dataset_sampled.withColumn(b, F.col(b).cast('integer'))

indexer = StringIndexer()
indexer.setHandleInvalid("keep")
indexer.setInputCols(categorical_ohe)
features_idx = list(map(lambda x: x + "_idx", categorical_ohe))
indexer.setOutputCols(features_idx)

cat_indexer = StringIndexer()
cat_indexer.setHandleInvalid("keep")
cat_indexer.setInputCols(categorical_as_cont)
features_cat_idx = list(map(lambda x: x + "_idx", categorical_as_cont))
cat_indexer.setOutputCols(features_cat_idx)

encoders = []
for f in features_idx:
    encoders.append(OneHotEncoder(inputCol=f, outputCol=f + "_enc"))

period = {
    "quarter": 4,
    "month": 12,
    "dayofmonth": 31,
    "dayofweek": 7
}
cyclical_encoders = []
for c in cyclical:
    cyclical_encoders.append(
        TimeTransformer(input_col=c, output_col=c).set_coef(coef=period[c])
    )

time_idx = []
time_encoders = []
for t in time_features:
    time_idx.append(t + '_hour')
    time_idx.append(t + '_minute')
    time_idx.append(t + '_day')
    time_idx.append(t + '_month')

    dataset_sampled = dataset_sampled.withColumn(t + '_hour', F.hour(t))
    dataset_sampled = dataset_sampled.withColumn(t + '_minute', F.minute(t))
    dataset_sampled = dataset_sampled.withColumn(t + '_day', F.dayofmonth(t))
    dataset_sampled = dataset_sampled.withColumn(t + '_month', F.month(t))

    time_encoders.append(
        TimeTransformer(input_col=t + '_hour', output_col=t + '_hour').set_coef(coef=24.0)
    )
    time_encoders.append(
        TimeTransformer(input_col=t + '_minute', output_col=t + '_minute').set_coef(coef=60.0)
    )
    time_encoders.append(
        TimeTransformer(input_col=t + '_day', output_col=t + '_day').set_coef(coef=31.0)
    )
    time_encoders.append(
        TimeTransformer(input_col=t + '_month', output_col=t + '_month').set_coef(coef=12.0)
    )

date_idx = []
date_encoders = []
for d in date_features:
    date_idx.append(d + '_day')
    date_idx.append(d + '_month')

    dataset_sampled = dataset_sampled.withColumn(d + '_day', F.dayofmonth(t))
    dataset_sampled = dataset_sampled.withColumn(d + '_month', F.month(t))

    date_encoders.append(TimeTransformer(input_col=d + '_day',
                                         output_col=d + '_day').set_coef(coef=31.0))
    date_encoders.append(TimeTransformer(input_col=d + '_month',
                                         output_col=d + '_month').set_coef(coef=12.0))

assembler = VectorAssembler(
    inputCols=[f + "_enc" for f in features_idx] +
              features_cat_idx + numerical + boolean_features +
              [f + "_sin" for f in time_idx] + [f + "_cos" for f in time_idx] +
              [f + "_sin" for f in date_idx] + [f + "_cos" for f in date_idx] +
              [f + "_sin" for f in cyclical] + [f + "_cos" for f in cyclical],
    outputCol='features_unscaled'
)

scaler = MinMaxScaler(inputCol="features_unscaled", outputCol="features")

pipeline = Pipeline(
    stages=[indexer, cat_indexer] + encoders + time_encoders +
    date_encoders + cyclical_encoders + [assembler, scaler])
FEATURES_PIPELINE_MODEL = pipeline.fit(dataset_sampled)
dataset_enc = FEATURES_PIPELINE_MODEL.transform(dataset_sampled)

label_indexer = StringIndexer()
label_indexer.setInputCol(LABEL)
label_indexer.setOutputCol('label')
LABEL_IDX_MODEL = label_indexer.fit(dataset_enc)

dataset_labeled = LABEL_IDX_MODEL.transform(dataset_enc)

dataset_proj = dataset_labeled.select('features', 'label')

TRAIN_RATIO = 0.7
train_df, test_df = dataset_proj.randomSplit([TRAIN_RATIO, 1 - TRAIN_RATIO], seed=42)

train_df.select("features", "label") \
    .write \
    .mode("overwrite") \
    .format('json') \
    .save(DATA_PATH + "/train")
run(f"hdfs dfs -cat {DATA_PATH}/train/*.json > {LOCAL_BASE_PATH}/data/train.json")
test_df.select("features", "label") \
    .write \
    .mode("overwrite") \
    .format("json") \
    .save(DATA_PATH + "/test")
run(f"hdfs dfs -cat {DATA_PATH}/test/*.json > {LOCAL_BASE_PATH}/data/test.json")
print("Dataset preprocessed successfully.")

# First model
print("\nTraining the first model - Random Forest Classifier...")
rf_calssifier = RandomForestClassifier()
rf_model = rf_calssifier.fit(train_df)
rf_predictions = rf_model.transform(test_df)

rf_evaluator_roc = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderROC")
rf_roc = rf_evaluator_roc.evaluate(rf_predictions)
rf_evaluator_pr = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderPR")
rf_pr = rf_evaluator_pr.evaluate(rf_predictions)
print(f"Test area under ROC for the first model: {rf_roc}")
print(f"Test area under PR for the first model: {rf_pr}")

# Fine-tune first model
print("Fine-tuning the first model...")

rf_grid = ParamGridBuilder()
rf_grid = rf_grid.addGrid(rf_model.maxDepth, [5, 10]) \
    .addGrid(rf_model.impurity, ['entropy', 'gini']) \
    .addGrid(rf_model.numTrees, [10, 20]) \
    .build()
rf_cv = CrossValidator(estimator=rf_calssifier,
                       estimatorParamMaps=rf_grid,
                       evaluator=rf_evaluator_roc,
                       parallelism=5,
                       numFolds=3)

RF_CV_MODEL = rf_cv.fit(train_df)
model1 = RF_CV_MODEL.bestModel

# Save best first model
model1.write().overwrite().save(MODEL_PATH + "/model1")
run(f"hdfs dfs -get {MODEL_PATH}/model1 {LOCAL_BASE_PATH}/models/model1")

print("Best hyperparameters for first model:")
print(f"\t maxDepth - {model1.getMaxDepth()}")
print(f"\t impurity - {model1.getImpurity()}")
print(f"\t numTrees - {model1.getNumTrees}\n")

# Predict and save predicion
rf_predictions_grid = model1.transform(test_df)
rf_predictions_grid.select("label", "prediction").coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ",") \
    .option("header", "true") \
    .save(OUTPUT_PATH + "/model1_predictions")
run(f"hdfs dfs -cat {OUTPUT_PATH}/model1_predictions/*.csv > \
{LOCAL_BASE_PATH}/output/model1_predictions.csv")

# Evaluate first best model
rf_evaluator_best_roc = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderROC")
rf_best_roc = rf_evaluator_best_roc.evaluate(rf_predictions_grid)
rf_evaluator_best_pr = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderPR")
rf_best_pr = rf_evaluator_best_pr.evaluate(rf_predictions_grid)
print(f"Test area under ROC for the first best model: {rf_best_roc}")
print(f"Test area under PR for the first best model: {rf_best_pr}")

# Second model
print("\nTraining the second model - Factorization Machines Classifier...")
fm_calssifier = FMClassifier()
fm_model = fm_calssifier.fit(train_df)
fm_predictions = fm_model.transform(test_df)

fm_evaluator_roc = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderROC")
fm_roc = fm_evaluator_roc.evaluate(fm_predictions)
fm_evaluator_pr = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderPR")
fm_pr = fm_evaluator_pr.evaluate(fm_predictions)
print(f"Test area under ROC for the second model: {fm_roc}")
print(f"Test area under PR for the second model: {fm_pr}")

# Fine-tune second model
print("Fine-tuning the second model...")

fm_grid = ParamGridBuilder()
fm_grid = fm_grid.addGrid(fm_model.regParam, [0.0, 0.5]) \
    .addGrid(fm_model.initStd, [0.01, 0.05]) \
    .addGrid(fm_model.factorSize, [4, 8]) \
    .build()
fm_cv = CrossValidator(estimator=fm_calssifier,
                       estimatorParamMaps=fm_grid,
                       evaluator=fm_evaluator_roc,
                       parallelism=5,
                       numFolds=3)
FM_CV_MODEL = fm_cv.fit(train_df)
model2 = FM_CV_MODEL.bestModel
print("\nBest hyperparameters for second model:")
print(f"\t initStd - {model2.getInitStd()}")
print(f"\t regParam - {model2.getRegParam()}")
print(f"\t factorSize - {model2.getFactorSize()}\n")

# Save best second model
model2.write().overwrite().save(MODEL_PATH + "/model2")
run(f"hdfs dfs -get {MODEL_PATH}/model2 {LOCAL_BASE_PATH}/models/model2")

# Predict and save predicion
fm_predictions_grid = model2.transform(test_df)
fm_predictions_grid.select("label", "prediction").coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ",") \
    .option("header", "true") \
    .save(OUTPUT_PATH + "/model2_predictions")
run(f"hdfs dfs -cat {OUTPUT_PATH}/model2_predictions/*.csv > \
{LOCAL_BASE_PATH}/output/model2_predictions.csv")

# Evaluate second best model
fm_evaluator_best_roc = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderROC")
fm_best_roc = fm_evaluator_best_roc.evaluate(fm_predictions_grid)
fm_evaluator_best_pr = BinaryClassificationEvaluator() \
    .setLabelCol("label") \
    .setRawPredictionCol("prediction") \
    .setMetricName("areaUnderPR")
fm_best_pr = fm_evaluator_best_pr.evaluate(fm_predictions_grid)
print(f"Test area under ROC for the second best model: {fm_best_roc}")
print(f"Test area under PR for the second best model: {fm_best_pr}")

print("\nBoth models built, fine-tuned and evaluated successfully.")

print("Saving necessary files for dashboard...")
# Create data frame to report performance of the models
models = [
    [str(model1), rf_best_roc, rf_best_pr],
    [str(model2), fm_best_roc, fm_best_pr]
]
result_df = spark.createDataFrame(models, ["model", "Area under ROC", "Area under PR"])

# Save it to HDFS and locally
result_df.coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ",") \
    .option("header", "true") \
    .save(OUTPUT_PATH + "/evaluation")
run(f"hdfs dfs -cat {OUTPUT_PATH}/evaluation/*.csv > \
{LOCAL_BASE_PATH}/output/evaluation.csv")

# Create data frame to store hyperparameters of the models
hypoparams = [
    [str(model1),
     f'maxDepth = {model1.getMaxDepth()}',
     f'impurity = {model1.getImpurity()}',
     f'numTrees = {model1.getNumTrees}'],
    [str(model2),
     f'initStd = {model2.getInitStd()}',
     f'regParam = {model2.getRegParam()}',
     f'factorSize = {model2.getFactorSize()}']
]
hypo_df = spark.createDataFrame(
    hypoparams,
    ["model", "Parameter 1", "Parameter 2", "Parameter 3"]
)

# Save it to HDFS and locally
hypo_df.coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ";") \
    .option("header", "true") \
    .save(OUTPUT_PATH + "/hyperparameters")
run(f"hdfs dfs -cat {OUTPUT_PATH}/hyperparameters/*.csv > \
{LOCAL_BASE_PATH}/output/hyperparameters.csv")

# Create data frame to optimization process of the models
optim_models = [
    [str(model1), rf_roc, rf_best_roc, rf_best_roc - rf_roc, rf_pr, rf_best_pr, rf_best_pr - rf_pr],
    [str(model2), fm_roc, fm_best_roc, fm_best_roc - fm_roc, fm_pr, fm_best_pr, fm_best_pr - fm_pr]
]
optim_df = spark.createDataFrame(
    optim_models,
    ["model", "Initial area under ROC", "Optimized area under ROC",
     "Increase of area under ROC", "Initial area under PR",
     "Optimized area under PR", "Increase of area under PR"]
)

# Save it to HDFS and locally
optim_df.coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ";") \
    .option("header", "true") \
    .save(OUTPUT_PATH + "/optimization")
run(f"hdfs dfs -cat {OUTPUT_PATH}/optimization/*.csv > \
{LOCAL_BASE_PATH}/output/optimization.csv")

# Get random sample and predict on both models
prediction_sample = dataset_labeled.sample(fraction=10 / dataset_labeled.count(), seed=123)
models_pred = model2.transform(model1.transform(prediction_sample)
                               .withColumnRenamed("prediction", "model1_prediction")
                               .withColumnRenamed("rawPrediction", "model1_rawPrediction")
                               .withColumnRenamed("probability", "model1_probability")) \
    .withColumnRenamed("prediction", "model2_prediction")
prediction_result = models_pred.select(*(numerical + cyclical +
                                         time_features + date_features +
                                         boolean_features + categorical_as_cont +
                                         categorical_ohe +
                                         ['label', "model1_prediction", "model2_prediction"])
)

# Save it to HDFS and locally
prediction_result.coalesce(1) \
    .write \
    .mode("overwrite") \
    .format("csv") \
    .option("sep", ";") \
    .option("header", "true") \
    .save(OUTPUT_PATH + "/prediction_samples")
run(f"hdfs dfs -cat {OUTPUT_PATH}/prediction_samples/*.csv > \
{LOCAL_BASE_PATH}/output/prediction_samples.csv")

print("All necessary files saved successfully.")

# After all processing is done, close the Spark session
spark.stop()
