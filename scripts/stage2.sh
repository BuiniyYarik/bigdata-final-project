#!/bin/bash


# Define base path
base_path=~/bigdata-final-project



# Part 1. Create Hive tables

echo "Preparing AVSC schemas and cleaning HDFS directories..."
# Copy local AVSC schemas to HDFS
hdfs dfs -rm -r -f -skipTrash /user/team22/project/warehouse/avsc > /dev/null 2>&1
hdfs dfs -mkdir -p /user/team22/project/warehouse/avsc
hdfs dfs -put $base_path/output/*.avsc /user/team22/project/warehouse/avsc

# Clear the warehouse directory
hdfs dfs -rm -r -f -skipTrash /user/team22/project/hive/warehouse > /dev/null 2>&1

# Read the password to access the database
password=$(head -n 1 $base_path/secrets/.hive.pass)

# Clear the output of Hive table queries
rm -f $base_path/output/hive_results.txt

# Create database and external table, check the content of table
echo "Creating database and temporary table in Hive..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p $password -f $base_path/sql/create_db.hql \
  > $base_path/output/hive_results.txt 2> /dev/null

# Create table with partitions and buckets
echo "Creating table with partitions and buckets..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p $password -f $base_path/sql/create_table.hql > /dev/null 2>&1

# Import data to table with partitions and buckets
echo "Importing data to Hive table..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p $password -f $base_path/sql/import_from_temp.hql > /dev/null 2>&1

echo "Hive setup and data import completed successfully."

