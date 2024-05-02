-- Add raw table flights
CREATE TABLE IF NOT EXISTS flights_raw (
    FlightDate DATE NOT NULL,
    Airline VARCHAR(150) NOT NULL,
    Origin VARCHAR(10) NOT NULL,
    Dest VARCHAR(10) NOT NULL,
    Cancelled BOOLEAN NOT NULL,
    Diverted BOOLEAN NOT NULL,
    CRSDepTime FLOAT NOT NULL,
    DepTime FLOAT,
    DepDelayMinutes FLOAT,
    DepDelay FLOAT,
    ArrTime FLOAT,
    ArrDelayMinutes FLOAT,
    AirTime FLOAT,
    CRSElapsedTime FLOAT,
    ActualElapsedTime FLOAT,
    Distance FLOAT,
    Year INT,
    Quarter INT,
    Month INT,
    DayofMonth INT,
    DayOfWeek INT,

    Marketing_Airline_Network VARCHAR(10) NOT NULL,
    Operated_or_Branded_Code_Share_Partners VARCHAR(100) NOT NULL,
    DOT_ID_Marketing_Airline INT NOT NULL,
    IATA_Code_Marketing_Airline VARCHAR(10) NOT NULL,
    Flight_Number_Marketing_Airline VARCHAR(10) NOT NULL,
    Operating_Airline VARCHAR(10) NOT NULL,
    DOT_ID_Operating_Airline INT NOT NULL,
    IATA_Code_Operating_Airline VARCHAR(10) NOT NULL,
    Tail_Number VARCHAR(10),    
    Flight_Number_Operating_Airline VARCHAR(10) NOT NULL,
    
    OriginAirportID INT NOT NULL,
    OriginAirportSeqID INT NOT NULL,
    OriginCityMarketID INT NOT NULL,
    OriginCityName VARCHAR(50) NOT NULL,
    OriginState VARCHAR(10) NOT NULL,
    OriginStateFips INT NOT NULL,
    OriginStateName VARCHAR(50) NOT NULL,
    OriginWac INT NOT NULL,
    DestAirportID INT NOT NULL,
    DestAirportSeqID INT NOT NULL,
    DestCityMarketID INT NOT NULL,
    DestCityName VARCHAR(50) NOT NULL,
    DestState VARCHAR(10) NOT NULL,
    DestStateFips INT NOT NULL,
    DestStateName VARCHAR(50) NOT NULL,
    DestWac INT,

    DepDel15 FLOAT,
    DepartureDelayGroups FLOAT,
    DepTimeBlk VARCHAR(20),
    TaxiOut FLOAT,
    WheelsOff FLOAT,
    WheelsOn FLOAT,
    TaxiIn FLOAT,
    CRSArrTime FLOAT,
    ArrDelay FLOAT,
    ArrDel15 FLOAT,
    ArrivalDelayGroups FLOAT,
    ArrTimeBlk VARCHAR(20),
    DistanceGroup INT,
    DivAirportLandings FLOAT
);


-- Add production table flights
CREATE TABLE IF NOT EXISTS flights (
    FlightDate DATE NOT NULL,
    Airline VARCHAR(150) NOT NULL,
    Origin VARCHAR(10) NOT NULL,
    Dest VARCHAR(10) NOT NULL,
    Cancelled BOOLEAN NOT NULL,
    Diverted BOOLEAN NOT NULL,
    CRSDepTime TIME NOT NULL,
    DepTime TIME,
    DepDelayMinutes INT,
    DepDelay INT,
    ArrTime TIME,
    ArrDelayMinutes INT,
    AirTime INT,
    CRSElapsedTime INT,
    ActualElapsedTime INT,
    Distance INT,
    Year INT,
    Quarter INT,
    Month INT,
    DayofMonth INT,
    DayOfWeek INT,

    Marketing_Airline_Network VARCHAR(10) NOT NULL,
    Operated_or_Branded_Code_Share_Partners VARCHAR(100) NOT NULL,
    DOT_ID_Marketing_Airline INT NOT NULL,
    IATA_Code_Marketing_Airline VARCHAR(10) NOT NULL,
    Flight_Number_Marketing_Airline VARCHAR(10) NOT NULL,
    Operating_Airline VARCHAR(10) NOT NULL,
    DOT_ID_Operating_Airline INT NOT NULL,
    IATA_Code_Operating_Airline VARCHAR(10) NOT NULL,
    Tail_Number VARCHAR(10),
    Flight_Number_Operating_Airline VARCHAR(10) NOT NULL,
    
    OriginAirportID INT NOT NULL,
    OriginAirportSeqID INT NOT NULL,
    OriginCityMarketID INT NOT NULL,
    OriginCityName VARCHAR(50) NOT NULL,
    OriginState VARCHAR(10) NOT NULL,
    OriginStateFips INT NOT NULL,
    OriginStateName VARCHAR(50) NOT NULL,
    OriginWac INT NOT NULL,
    DestAirportID INT NOT NULL,
    DestAirportSeqID INT NOT NULL,
    DestCityMarketID INT NOT NULL,
    DestCityName VARCHAR(50) NOT NULL,
    DestState VARCHAR(10) NOT NULL,
    DestStateFips INT NOT NULL,
    DestStateName VARCHAR(50) NOT NULL,
    DestWac INT,

    DepDel15 BOOLEAN,
    DepartureDelayGroups INT,
    DepTimeBlk VARCHAR(20),
    TaxiOut INT,
    WheelsOff TIME,
    WheelsOn TIME,
    TaxiIn INT,
    CRSArrTime TIME,
    ArrDelay INT,
    ArrDel15 BOOLEAN,
    ArrivalDelayGroups INT,
    ArrTimeBlk VARCHAR(20),
    DistanceGroup INT,
    DivAirportLandings INT,
    PRIMARY KEY (
        FlightDate, 
        Marketing_Airline_Network, 
        Flight_Number_Marketing_Airline, 
        OriginAirportID, 
        DestAirportID, 
        CRSDepTime
    )
);
