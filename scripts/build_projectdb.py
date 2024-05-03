"""
This module handles the creation of tables, data import,
and data processing for a PostgreSQL database.
"""

import os
import psycopg2 as psql


def check_table_exists_and_has_data(cursor, table_name):
    """
    Check if a table exists in the database and if it contains any data.

    Parameters:
    - cursor: The database cursor object.
    - table_name: The name of the table to check.

    Returns:
    - table_exists (bool): True if the table exists, False otherwise.
    - table_has_data (bool): True if the table contains data, False otherwise.
    """
    cursor.execute(f"""
        SELECT EXISTS (
            SELECT FROM information_schema.tables
            WHERE table_schema = 'public' AND table_name = '{table_name}');
    """)
    table_exists = cursor.fetchone()[0]

    if table_exists:
        cursor.execute(f"SELECT EXISTS (SELECT 1 FROM {table_name} LIMIT 1);")
        table_has_data = cursor.fetchone()[0]
        return table_exists, table_has_data
    return table_exists, False


# Define constants
BASE_PATH = os.path.expanduser("~/bigdata-final-project")
FILE_PATH = os.path.join(BASE_PATH, "secrets/.psql.pass")
DATA_FILENAME = "Combined_Flights_2021.csv"
HOSTNAME = 'hadoop-04.uni.innopolis.ru'
PORT = '5432'
USERNAME = 'team22'
DATABASE_NAME = 'team22_projectdb'

# Read password from secrets file
with open(FILE_PATH, "r", encoding="utf-8") as file:
    PASSWORD = file.read().rstrip()

# Build the connection string
CONN_STRING = f"host={HOSTNAME} port={PORT} \
                dbname={DATABASE_NAME} user={USERNAME} password={PASSWORD}"

# Connect to the PostgreSQL database
with psql.connect(CONN_STRING) as conn:
    cur = conn.cursor()

    # Check if the 'flights' table exists and if it has data
    exists, has_data = check_table_exists_and_has_data(cur, 'flights')

    if not exists or not has_data:
        # Create tables if they do not exist
        print("Creating tables...")
        with open(
               os.path.join(BASE_PATH, "sql/create_tables.sql"), "r", encoding="utf-8"
        ) as file:
            content = file.read()
            cur.execute(content)
        conn.commit()
        print("Tables created successfully!")

        # Import data if the 'flights' table is empty
        print("Importing data to raw table...")
        with open(
            os.path.join(BASE_PATH, "sql/import_to_raw.sql"), "r", encoding="utf-8"
        ) as file:
            command = file.read()
            with open(
                os.path.join(BASE_PATH, "data", DATA_FILENAME), "r", encoding="utf-8"
            ) as flights_raw:
                cur.copy_expert(command, flights_raw)
        conn.commit()
        print("Raw data imported successfully!")

        # Process data from raw to production table
        print("Processing raw data to production table...")
        with open(
            os.path.join(BASE_PATH, "sql/process_to_prod.sql"), "r", encoding="utf-8"
        ) as file:
            content = file.read()
            cur.execute(content)
        conn.commit()
        print("Data processed successfully!")

    else:
        # Notify if the table already contains data
        print("The 'flights' table already exists and contains data. No need to import.")
