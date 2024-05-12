#!/bin/bash


# Define base path
base_path=~/bigdata-final-project



# Part 1. Create tables in the relational database and import data

python3 $base_path/scripts/build_projectdb.py



# Part 2. Import data to HDFS and process

# Removing old warehouse directory
hdfs dfs -rm -r -f -skipTrash /user/team22/project/warehouse > /dev/null 2>&1

# Read database password
password=$(head -n 1 $base_path/secrets/.psql.pass)

# Import table to HDFS via Sqoop
echo "Performing Sqoop job to import the table to HDFS..."
sqoop import-all-tables \
  --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team22_projectdb \
  --username team22 \
  --password "$password" \
  --compression-codec snappy \
  --compress \
  --as-avrodatafile \
  --warehouse-dir /user/team22/project/warehouse \
  --m 1 2> /dev/null

# Ensure output directory exists and is clean
mkdir -p $base_path/output
rm -f $base_path/output/*.avsc $base_path/output/*.java

# Move AVSC and Java files to output folder
mv ./*.avsc $base_path/output/
mv ./*.java $base_path/output/

printf "Data import and processing completed successfully.\n"
printf "\n"
