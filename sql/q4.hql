USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.q4_results;
CREATE EXTERNAL TABLE team22_projectdb.q4_results(
FlightsNumber INTEGER,
Status VARCHAR(30))
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location '/user/team22/project/hive/warehouse/q4'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Operating and Marketing Airlines
INSERT INTO q4_results
SELECT sum(FlightsNumber) AS FlightsNum, 
CASE WHEN IsMarketing AND (NumberMerketingAirlines = 1) THEN "Single internal marketing" ELSE 
CASE WHEN IsMarketing AND (NumberMerketingAirlines > 1) THEN "Multiple internal marketing" ELSE 
CASE WHEN (NumberMerketingAirlines > 1) THEN "Multiple external marketing" ELSE  "Single external marketing"  
END
END
END AS Status
FROM 
(SELECT DOT_ID_Operating_Airline, 
array_contains(collect_list(DOT_ID_Marketing_Airline), DOT_ID_Operating_Airline) AS IsMarketing,
count(DOT_ID_Marketing_Airline) AS NumberMerketingAirlines,
sum(counter) AS FlightsNumber
FROM
(SELECT DOT_ID_Operating_Airline, DOT_ID_Marketing_Airline, count(*) as counter
FROM team22_projectdb.flights
GROUP BY DOT_ID_Operating_Airline, DOT_ID_Marketing_Airline) AS t
GROUP BY DOT_ID_Operating_Airline) AS oper_t
GROUP BY CASE WHEN IsMarketing AND (NumberMerketingAirlines = 1) THEN "Single internal marketing" ELSE 
CASE WHEN IsMarketing AND (NumberMerketingAirlines > 1) THEN "Multiple internal marketing" ELSE 
CASE WHEN (NumberMerketingAirlines > 1) THEN "Multiple external marketing" ELSE  "Single external marketing"  
END
END
END;

SELECT * FROM q4_results;
