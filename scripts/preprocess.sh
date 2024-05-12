#!/bin/bash


# Define base path
base_path=~/bigdata-final-project


# Download and save dataset from Kaggle if it is not downloaded yet

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

        printf "File unzipped successfully.\n"
        printf "\n"

        # Remove the ZIP file after extraction
        rm -f "$directory/$zip_file"
    else
        echo "Failed to download the ZIP file."
    fi
else
    printf "$file already exists, skipping download.\n"
    printf "\n"
fi
