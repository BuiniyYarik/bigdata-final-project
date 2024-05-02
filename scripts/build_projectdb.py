import psycopg2 as psql
import os


def check_table_exists_and_has_data(cursor, table_name):
    """
    Check if a table exists in the database and if it contains any data.

    Parameters:
    - cursor: The database cursor object.
    - table_name: The name of the table to check.

    Returns:
    - exists (bool): True if the table exists, False otherwise.
    - has_data (bool): True if the table contains data, False otherwise.
    """
    # Check if the specified table exists in the public schema
    cursor.execute(f"""
        SELECT EXISTS (
            SELECT FROM information_schema.tables 
            WHERE table_schema = 'public' AND table_name = '{table_name}');
    """)
    exists = cursor.fetchone()[0]

    # If the table exists, check if it has any data
    if exists:
        cursor.execute(f"SELECT EXISTS (SELECT 1 FROM {table_name} LIMIT 1);")
        has_data = cursor.fetchone()[0]
        return exists, has_data
    return exists, False


# Read password from secrets file
file_path = os.path.join("../secrets", ".psql.pass")
with open(file_path, "r") as file:
    password = file.read().rstrip()


# Define the name of the CSV file with data to import
data_filename = "Combined_Flights_2021.csv"


# Build the connection string
hostname = 'hadoop-04.uni.innopolis.ru'
port = '5432'
username = 'team22'
database_name = 'team22_projectdb'
conn_string = f"host={hostname} port={port} dbname={database_name} user={username} password={password}"


# Connect to the PostgreSQL database
with psql.connect(conn_string) as conn:
    cur = conn.cursor()

    # Check if the 'flights' table exists and if it has data
    exists, has_data = check_table_exists_and_has_data(cur, 'flights')

    if not exists or not has_data:

        # Create tables if they do not exist
        print("Creating tables...")
        with open(os.path.join("../sql", "create_tables.sql")) as file:
            content = file.read()
            cur.execute(content)
        conn.commit()
        print("Tables created successfully!")


        # Import data if the 'flights' table is empty
        print("Importing data to raw table...")
        with open(os.path.join("../sql", "import_to_raw.sql")) as file:
            command = file.read()
            with open(os.path.join("../data", data_filename), "r") as flights_raw:
                cur.copy_expert(command, flights_raw)
        conn.commit()
        print("Raw data imported successfully!")


        # Process data from raw to production table
        print("Processing raw data to production table...")
        with open(os.path.join("../sql", "process_to_prod.sql")) as file:
            content = file.read()
            cur.execute(content)
        conn.commit()
        print("Data processed successfully!")

    else:
        # Notify if the table already contains data
        print("The 'flights' table already exists and contains data. No need to import.")
