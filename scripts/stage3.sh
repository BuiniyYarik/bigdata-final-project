#!/bin/bash


# Define the variable for the log4j configuration file path
conf_path="~/.spark/conf/log4j.properties"


# Run script with ML Model Training, Tuning, and Evaluation
spark-submit \
  --master yarn \
  --conf "spark.driver.extraJavaOptions=-Dlog4j.configuration=file:$conf_path" \
  --conf "spark.executor.extraJavaOptions=-Dlog4j.configuration=file:$conf_path" \
  ~/bigdata-final-project/scripts/build_model.py
