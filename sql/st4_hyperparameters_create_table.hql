USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.hyperparameters;
CREATE EXTERNAL TABLE team22_projectdb.hyperparameters(
Model VARCHAR(150), 
Parameter1 VARCHAR(20), 
Parameter2 VARCHAR(20), 
Parameter3 VARCHAR(20))
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
location '/user/team22/project/hive/warehouse/hyperparameters'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Insert data from csv file
-- LOAD DATA INPATH '/user/team22/project/output/hyperparameters/*.csv' OVERWRITE INTO TABLE team22_projectdb.hyperparameters;