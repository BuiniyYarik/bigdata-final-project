USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.q2_results;
CREATE EXTERNAL TABLE team22_projectdb.q2_results(
OriginAirport VARCHAR(3),
DestAirport VARCHAR(3),
OriginCancelProportion FLOAT, 
DestCancelProportion FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location '/user/team22/project/hive/warehouse/q2'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Cancellations statistics in Airport
INSERT INTO q2_results
SELECT origin_table.Airport AS OriginAirport, dest_table.Airport AS DestAirport, OriginCancelProportion, DestCancelProportion  FROM
(SELECT origin as Airport, 
count(CASE WHEN cancelled THEN 1 END) / count(*) AS OriginCancelProportion 
FROM team22_projectdb.flights 
GROUP by origin) AS origin_table
FULL OUTER JOIN 
(SELECT dest as Airport, 
count(CASE WHEN cancelled THEN 1 END) / count(*) AS DestCancelProportion 
FROM team22_projectdb.flights 
GROUP by dest) AS dest_table
ON origin_table.Airport = dest_table.Airport;

SELECT * FROM q2_results;
