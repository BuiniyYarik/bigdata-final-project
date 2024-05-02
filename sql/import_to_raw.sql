-- Import data to raw table
COPY flights_raw FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '"' NULL AS '';
