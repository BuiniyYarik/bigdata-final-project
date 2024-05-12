USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.q3_results;
CREATE EXTERNAL TABLE team22_projectdb.q3_results(
OriginCity VARCHAR(50),
DestCity VARCHAR(50), 
FlightOut INTEGER, 
FlightIn INTEGER)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
location '/user/team22/project/hive/warehouse/q3'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Number of flight in and out of the city
INSERT INTO q3_results
SELECT OriginCity,DestCity, FlightOut, FlightIn FROM
(SELECT OriginCityName as OriginCity, count(*) AS FlightOut FROM team22_projectdb.flights GROUP by OriginCityName) AS origin_table
FULL OUTER JOIN 
(SELECT DestCityName as DestCity, count(*) AS FlightIn FROM team22_projectdb.flights GROUP by DestCityName) AS dest_table
ON origin_table.OriginCity = dest_table.DestCity
ORDER BY FlightOut DESC, FlightIn DESC;

SELECT * FROM q3_results;
