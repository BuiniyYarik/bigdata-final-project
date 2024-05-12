USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.optimization;
CREATE EXTERNAL TABLE team22_projectdb.optimization(
Model VARCHAR(150), 
InitialAreaUnderROC FLOAT,
OptimizedAreaUnderROC FLOAT,
IncreaseAreaUnderPR FLOAT,
InitialAreaUnderPR FLOAT,
OptimizedAreaUnderPR FLOAT,
IncreaseAreaUnderROC FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
location '/user/team22/project/hive/warehouse/optimization'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Insert data from csv file
-- LOAD DATA INPATH '/user/team22/project/output/optimization/*.csv' OVERWRITE INTO TABLE team22_projectdb.optimization;