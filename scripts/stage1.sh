#!/bin/bash


# Define base path
base_path=~/bigdata-final-project



# Part 1. Download and save dataset from Kaggle if it is not downloaded yet

# Set the data directory and file name
directory="$base_path/data"
file="Combined_Flights_2021.csv"
zip_file="Combined_Flights_2021.csv.zip"

# Ensure the data directory exists
mkdir -p $directory

# Check if the CSV file already exists
if [ ! -f "$directory/$file" ]; then
    echo "$file does not exist, downloading..."

    # Download the specific file using Kaggle CLI
    kaggle datasets download robikscube/flight-delay-dataset-20182022 --file $zip_file --path $directory

    # Check if the ZIP file was downloaded
    if [ -f "$directory/$zip_file" ]; then
        echo "Unzipping $zip_file..."

        # Unzip the file
        unzip "$directory/$zip_file" -d $directory

        echo "File unzipped successfully."

        # Remove the ZIP file after extraction
        rm -f "$directory/$zip_file"
    else
        echo "Failed to download the ZIP file."
    fi
else
    echo "$file already exists, skipping download."
fi



# Part 2. Create tables in the relational database and import data

python3 $base_path/scripts/build_projectdb.py



# Part 3. Import data to HDFS and process

# Removing old warehouse directory
hdfs dfs -rm -r -f -skipTrash /user/team22/project/warehouse > /dev/null 2>&1

# Read database password
password=$(head -n 1 $base_path/secrets/.psql.pass)

# Import table to HDFS via Sqoop
echo "Performing Sqoop job to import all tables..."
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

echo "Data import and processing completed successfully."

