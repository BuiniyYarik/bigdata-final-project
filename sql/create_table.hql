-- Access the database
USE team22_projectdb;


-- Create table with partitions and buckets
CREATE EXTERNAL TABLE flights (
    FlightDate DATE,
    Airline VARCHAR(100),
    Origin VARCHAR(3),
    Dest VARCHAR(3),
    Cancelled BOOLEAN,
    Diverted BOOLEAN,
    CRSDepTime TIMESTAMP,
    DepTime TIMESTAMP,
    DepDelayMinutes INT,
    DepDelay INT,
    ArrTime TIMESTAMP,
    ArrDelayMinutes INT,
    AirTime INT,
    CRSElapsedTime INT,
    ActualElapsedTime INT,
    Distance INT,
    Year INT,
    Quarter INT,
    DayofMonth INT,
    DayOfWeek INT,

    Marketing_Airline_Network VARCHAR(2),
    Operated_or_Branded_Code_Share_Partners VARCHAR(12),
    DOT_ID_Marketing_Airline BIGINT,
    IATA_Code_Marketing_Airline VARCHAR(2),
    Flight_Number_Marketing_Airline BIGINT,
    Operating_Airline VARCHAR(2),
    DOT_ID_Operating_Airline BIGINT,
    IATA_Code_Operating_Airline VARCHAR(2),
    Tail_Number VARCHAR(6),
    Flight_Number_Operating_Airline BIGINT,
    
    OriginAirportID BIGINT,
    OriginAirportSeqID BIGINT,
    OriginCityMarketID INT,
    OriginCityName VARCHAR(50),
    OriginState VARCHAR(10),
    OriginStateFips INT,
    OriginStateName VARCHAR(50),
    OriginWac INT,
    DestAirportID INT,
    DestAirportSeqID INT,
    DestCityMarketID INT,
    DestCityName VARCHAR(50),
    DestState VARCHAR(10),
    DestStateFips INT,
    DestStateName VARCHAR(50),
    DestWac INT,
    
    DepDel15 BOOLEAN,
    DepartureDelayGroups INT,
    DepTimeBlk VARCHAR(20),
    TaxiOut INT,
    WheelsOff VARCHAR(5),
    WheelsOn VARCHAR(5),
    TaxiIn INT,
    CRSArrTime VARCHAR(5),
    ArrDelay INT,
    ArrDel15 BOOLEAN,
    ArrivalDelayGroups INT,
    ArrTimeBlk VARCHAR(20),
    DistanceGroup INT,
    DivAirportLandings INT
) 
PARTITIONED BY (Month INT)
CLUSTERED BY (DayofMonth) INTO 4 BUCKETS
STORED AS AVRO LOCATION '/user/team22/project/hive/warehouse/flights' 
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');
