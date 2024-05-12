This file contains brief information about the files in the output folder.

Stage 1:
- `flights.avsc` contains the Avro schema for the flights data
- `flights.java` contains the Java classes generated from the Avro schema

Stage 2:
- `hive_results.txt` contains the results of the query from the temporary table in Hive
- `q1.csv`, `q2.csv`, `q3.csv`, `q4.csv`, `q5.csv`, `q6.csv` contain outputs from the insights creation
- `q1.jpg`, `q2.jpg`, `q3.jpg`, `q4.jpg`, `q5.jpg`, `q6.jpg` are vizual representation of the insights made in Apache Superset

Stage 3:
- `evaluation.csv` contains the evaluation metrics for the models
- `hyperparameters.csv` contains the best hyperparameters used for the models
- `model1_predictions.csv` contains the predictions made by the fine-tuned first model
- `model2_predictions.csv` contains the predictions made by the fine-tuned second model
- `optimization.csv` contains the optimization results for the models
- `prediction_samples.csv` contains a sample of the predictions made by the models

Stage 4:
- `pipeline.png` is a graphical representation of the data pipeline
