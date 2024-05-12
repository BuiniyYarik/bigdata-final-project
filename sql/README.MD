This file contains brief information about the SQL files in the repository.

Stage 1:
- `create_tables.sql` creates 2 tables in the PostgreSQL database.
- `import_to_raw.sql` inserts data into the table with raw data.
- `process_from_raw.sql` processes the raw data and inserts the processed data into the primary table.

Stage 2:
- `create_db.hql` creates a database in Hive.
- `create_table.hql` creates the primary table in Hive.
- `import_from_temp.hql` imports data from the temporary table to the primary table applying necessary type casting.
- `q1.hql` is the first query that is used to get insights.
- `q2.hql` is the second query that is used to get insights.
- `q3.hql` is the third query that is used to get insights.
- `q4.hql` is the fourth query that is used to get insights.
- `q5.hql` is the fifth query that is used to get insights.
- `q6.hql` is the sixth query that is used to get insights.

Stage 3:
- `st4_hyperparameters_create_table.hql` creates a table to store the hyperparameters of the model.
- `st4_optimization_results_create_table.hql` creates a table to store the optimization results of the model.
- `st4_prediction_sample_create_table.hql` creates a table to store the prediction samples of the model.
