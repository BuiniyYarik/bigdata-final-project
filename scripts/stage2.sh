#!/bin/bash


# Define base paths
base_path=~/bigdata-final-project
base_hdfs_path=/user/team22/project



# Part 1. Create Hive tables

echo "Preparing AVSC schemas and cleaning HDFS directories..."
# Copy local AVSC schemas to HDFS
hdfs dfs -rm -r -f -skipTrash $base_hdfs_path/warehouse/avsc > /dev/null 2>&1
hdfs dfs -mkdir -p $base_hdfs_path/warehouse/avsc
hdfs dfs -put $base_path/output/*.avsc $base_hdfs_path/warehouse/avsc

# Clear the warehouse directory
hdfs dfs -rm -r -f -skipTrash $base_hdfs_path/hive/warehouse > /dev/null 2>&1

# Read the password to access the database
password=$(head -n 1 $base_path/secrets/.hive.pass)

# Clear the output of Hive table queries
rm -f $base_path/output/hive_results.txt


# Create database and external table, check the content of the table
echo "Creating database and temporary table in Hive..."
if ! beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p "$password" -f $base_path/sql/create_db.hql --silent=true --outputformat=table > $base_path/output/temp_hive_results.txt 2> /dev/null; then
    echo "Failed to create database and temporary table in Hive."
    exit 1
fi

# Remove empty lines from output file
awk 'NF > 0' $base_path/output/temp_hive_results.txt > $base_path/output/hive_results.txt
rm $base_path/output/temp_hive_results.txt


# Create table with partitions and buckets
echo "Creating table with partitions and buckets..."
if ! beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p "$password" -f $base_path/sql/create_table.hql > /dev/null 2>&1; then
    echo "Failed to create table with partitions and buckets."
    exit 1
fi


# Import data to table with partitions and buckets
echo "Importing data to Hive table..."
if ! beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p "$password" -f $base_path/sql/import_from_temp.hql > /dev/null 2>&1; then
    echo "Failed to import data to Hive table."
    exit 1
fi

echo "Hive setup and data import completed successfully."



# Part 2. Perform EDA

echo "Clearing files with queries output if they exist..."
rm -f $base_path/output/q*.csv
hdfs dfs -rm -r -f -skipTrash $base_hdfs_path/hive/warehouse/q* > /dev/null 2>&1

# Execute queries and store results
queries=(1 2 3 4 5 6)
for i in "${queries[@]}"; do
    echo "Running query $i to gather insights..."
    if ! beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team22 -p "$password" -f $base_path/sql/q"$i".hql --hiveconf hive.resultset.use.unique.column.names=false > $base_path/output/q"$i".csv 2>/dev/null; then
        echo "Failed to execute query $i."
        exit 1
    fi
done

echo "EDA and insights creation completed."
