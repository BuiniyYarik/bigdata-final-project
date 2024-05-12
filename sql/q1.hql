USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.q1_results;
CREATE EXTERNAL TABLE team22_projectdb.q1_results(
DepStatus VARCHAR(10), 
ArrStatus VARCHAR(10),
DepNum INTEGER,
ArrNum INTEGER)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location '/user/team22/project/hive/warehouse/q1'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- How many departures and arrivals were earlier, delayed, in time or cancelled
INSERT INTO q1_results
SELECT DepTable.Status, ArrTable.Status, DepNum, ArrNum
FROM
(
SELECT CASE WHEN cancelled THEN "Cancelled" ELSE
CASE WHEN depdelay <= -5 THEN "Earlier" ELSE 
CASE WHEN depdelay >= 5 THEN "Delayed" ELSE "In time"
END
END
END AS Status,
count(*) as DepNum
FROM team22_projectdb.flights
GROUP BY CASE WHEN cancelled THEN "Cancelled" ELSE
CASE WHEN depdelay <= -5 THEN "Earlier" ELSE 
CASE WHEN depdelay >= 5 THEN "Delayed" ELSE "In time"
END
END
END 
) AS DepTable
FULL OUTER JOIN
(SELECT CASE WHEN cancelled THEN "Cancelled" ELSE
CASE WHEN arrdelay <= -5 THEN "Earlier" ELSE 
CASE WHEN arrdelay >= 5 THEN "Delayed" ELSE "In time"
END
END
END AS Status,
count(*) as ArrNum
FROM team22_projectdb.flights
GROUP BY CASE WHEN cancelled THEN "Cancelled" ELSE
CASE WHEN arrdelay <= -5 THEN "Earlier" ELSE 
CASE WHEN arrdelay >= 5 THEN "Delayed" ELSE "In time"
END
END
END ) AS ArrTable
ON DepTable.Status = ArrTable.Status;

SELECT * FROM q1_results;
