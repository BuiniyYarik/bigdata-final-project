USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.q6_results;
CREATE EXTERNAL TABLE team22_projectdb.q6_results(
month INTEGER, 
TotalNum INTEGER,
CancelledNum INTEGER,
CancelProportion FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location '/user/team22/project/hive/warehouse/q6'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Cancellation rate by month
INSERT INTO q6_results
SELECT t.month, t.TotalNum, t.CancelledNum, t.CancelledNum / t.TotalNum AS CancelProportion
FROM (SELECT month, count(*) AS TotalNum, count(CASE WHEN cancelled THEN 1 END) AS CancelledNum
FROM team22_projectdb.flights GROUP by month) AS t
ORDER BY month;

SELECT * FROM q6_results;
