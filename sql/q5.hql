USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.q5_results;
CREATE EXTERNAL TABLE team22_projectdb.q5_results(
dayofmonth INTEGER, 
TotalNum INTEGER,
CancelledNum INTEGER,
CancelProportion FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location '/user/team22/project/hive/warehouse/q5'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Cancellation rate by day of month
INSERT INTO q5_results
SELECT t.dayofmonth, t.TotalNum, t.CancelledNum, t.CancelledNum / t.TotalNum AS CancelProportion
FROM (SELECT dayofmonth, count(*) AS TotalNum, count(CASE WHEN cancelled THEN 1 END) AS CancelledNum
FROM team22_projectdb.flights GROUP by dayofmonth) AS t
ORDER BY dayofmonth;


SELECT * FROM q5_results;
