#!/bin/bash


# Define the base path for the project
base_path=~/bigdata-final-project

# List of subdirectories to check for .ipynb_checkpoints
subdirs=("data" "models" "output" "scripts" "sql" "notebooks")


# Loop through each subdirectory and remove .ipynb_checkpoints if they exist
echo "Cleaning cache..."
for dir in "${subdirs[@]}"; do
    rm -rf "$base_path/$dir/.ipynb_checkpoints"
done

printf "Cleanup completed.\n"
