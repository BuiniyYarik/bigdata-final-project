This file contains brief information about the scripts in the scripts folder.

Stage 1:
- `preprocess.sh` is a shell script used to download CSV dataset from Kaggle
- `build_projectdb.py` is a Python script used for building the project PostgreSQL database including temporary and primary tables creation and data import
- `stage1.sh` is a shell script used for executing tasks in the first stage of the project

Stage 2:
- `stage2.sh` is a shell script used for executing tasks in the second stage of the project

Stage 3:
- `build_model.py` is a Python script used for building the machine learning models
- `stage3.sh` is a shell script used for executing tasks in the third stage of the project

Stage 4:
- `stage4.sh` is a shell script used for executing tasks in the fourth stage of the project
- `postprocess.sh` is a shell script used for deleting .ipynb cache files
