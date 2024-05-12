-- Drop database if it already exists
DROP DATABASE IF EXISTS team22_projectdb CASCADE;


-- Create database and access it
CREATE DATABASE team22_projectdb LOCATION '/user/team22/project/hive/warehouse';
USE team22_projectdb;


-- Create temporary table in database
CREATE EXTERNAL TABLE flights_temp STORED AS AVRO LOCATION '/user/team22/project/warehouse/flights'
TBLPROPERTIES ('avro.schema.url'='/user/team22/project/warehouse/avsc/flights.avsc');


-- Check the content of table
SELECT * FROM flights_temp LIMIT 10;
