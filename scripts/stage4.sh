#!/bin/bash


# Define base paths
base_path=~/bigdata-final-project
base_hdfs_path=/user/team22/project

# Read the password to access the database
password=$(head -n 1 $base_path/secrets/.hive.pass)

# Clear files that will be stored
echo "Clearing local files with model output..."
hdfs dfs -rm -r -f $base_hdfs_path/hive/warehouse/hyperparameters > /dev/null 2>&1
hdfs dfs -rm -r -f $base_hdfs_path/hive/warehouse/prediction_samples > /dev/null 2>&1
hdfs dfs -rm -r -f $base_hdfs_path/hive/warehouse/optimization > /dev/null 2>&1
echo "Finished clearing."

echo "Loading ML modelling results..."
hdfs dfs -cp -f $base_hdfs_path/output/hyperparameters/ $base_hdfs_path/hive/warehouse/
hdfs dfs -cp -f $base_hdfs_path/output/prediction_samples/ $base_hdfs_path/hive/warehouse/
hdfs dfs -cp -f $base_hdfs_path/output/optimization/ $base_hdfs_path/hive/warehouse/
# > /dev/null 2>&1

# Load ML modelling results into Hive tables
echo "Creating Hive table with hyperparameters info..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p $password -f $base_path/sql/st4_hyperparameters_create_table.hql --hiveconf hive.resultset.use.unique.column.names=false > /dev/null 2>&1
echo "Finished loading hyperparameters info."

echo "Creating Hive table with prediction samples..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p $password -f $base_path/sql/st4_prediction_samples_create_table.hql --hiveconf hive.resultset.use.unique.column.names=false > /dev/null 2>&1
echo "Finished loading prediction samples."

echo "Creating Hive table with optimization results..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p $password -f $base_path/sql/st4_optimization_results_create_table.hql --hiveconf hive.resultset.use.unique.column.names=false > /dev/null 2>&1
echo "Finished loading optimization results."

printf "ML results loaded successfully.\n"
printf "\n"
