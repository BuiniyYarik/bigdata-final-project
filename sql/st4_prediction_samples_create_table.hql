USE team22_projectdb;

DROP TABLE IF EXISTS team22_projectdb.prediction_samples;
CREATE EXTERNAL TABLE team22_projectdb.prediction_samples(
    DepDelayMinutes INT,
    DepDelay INT,
    ArrDelayMinutes INT,
    AirTime INT,
    CRSElapsedTime INT,
    ActualElapsedTime INT,
    Distance INT,
    Year INT,
    
    Flight_Number_Marketing_Airline BIGINT,
    Flight_Number_Operating_Airline BIGINT,
    OriginAirportID BIGINT,
    OriginAirportSeqID BIGINT,
    OriginCityMarketID BIGINT,
    OriginStateFips INT,
    OriginWac INT,
    DestAirportID BIGINT,
    DestAirportSeqID BIGINT,
    DestCityMarketID BIGINT,
    DestStateFips INT,
    DestWac INT,

    DepartureDelayGroups INT,
    TaxiOut INT,
    TaxiIn INT,
    ArrDelay INT,
    ArrivalDelayGroups INT,
    DistanceGroup INT,
    Quarter INT,
    Month INT,
    DayofMonth INT,
    DayOfWeek INT,
    
    CRSDepTime VARCHAR(30),
    DepTime VARCHAR(30),
    CRSArrTime VARCHAR(30),
    ArrTime VARCHAR(30),
    WheelsOn VARCHAR(30),
    WheelsOff VARCHAR(30),
    FlightDate DATE,
    
    Diverted INT, 
    DepDel15 INT,
    ArrDel15 INT,
    Origin VARCHAR(3),
    Dest VARCHAR(3),
    
    Tail_Number VARCHAR(6),
    OriginCityName VARCHAR(50),
    DestCityName VARCHAR(50),
    Airline VARCHAR(100),
    Marketing_Airline_Network VARCHAR(2),
    Operated_or_Branded_Code_Share_Partners VARCHAR(12),
    IATA_Code_Marketing_Airline VARCHAR(2),
    Operating_Airline VARCHAR(2),

    IATA_Code_Operating_Airline VARCHAR(2),
    OriginState VARCHAR(2),
    OriginStateName VARCHAR(50),
    DestState VARCHAR(10),
    DestStateName VARCHAR(50),
    DepTimeBlk VARCHAR(9),
    ArrTimeBlk VARCHAR(9),
    
    DivAirportLandings INT,
    DOT_ID_Marketing_Airline BIGINT,
    DOT_ID_Operating_Airline BIGINT,

    label INT,
    model1_prediction INT,
    model2_prediction INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ';'
location '/user/team22/project/hive/warehouse/prediction_samples'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

-- Insert data from csv file
-- LOAD DATA INPATH '/user/team22/project/hive/warehouse/prediction_samples/*.csv' OVERWRITE INTO TABLE team22_projectdb.prediction_samples;