-- Access the database
USE team22_projectdb;


-- Import data to Hive table with partitions and buckets from temporary table
INSERT INTO TABLE flights
SELECT
    to_date(from_unixtime(CAST(FlightDate / 1000 AS BIGINT), 'yyyy-MM-dd HH:mm:ss')) AS FlightDate,
    Airline,
    Origin,
    Dest,
    Cancelled,
    Diverted,
    CAST(concat_ws(' ',
        date_format(from_unixtime(CAST(FlightDate / 1000 AS BIGINT)), 'yyyy-MM-dd'),
        from_unixtime(CAST(CRSDepTime / 1000 AS BIGINT), 'HH:mm:ss')
    ) AS TIMESTAMP) AS CRSDepTime,
    CAST(concat_ws(' ',
        date_format(from_unixtime(CAST(FlightDate / 1000 AS BIGINT)), 'yyyy-MM-dd'),
        from_unixtime(CAST(DepTime / 1000 AS BIGINT), 'HH:mm:ss')
    ) AS TIMESTAMP) AS DepTime,
    DepDelayMinutes,
    DepDelay,
    ArrTime,
    ArrDelayMinutes,
    AirTime,
    CRSElapsedTime,
    ActualElapsedTime,
    Distance,
    Year,
    Quarter,
    DayofMonth,
    DayOfWeek,
    Marketing_Airline_Network,
    Operated_or_Branded_Code_Share_Partners,
    DOT_ID_Marketing_Airline,
    IATA_Code_Marketing_Airline,
    Flight_Number_Marketing_Airline,
    Operating_Airline,
    DOT_ID_Operating_Airline,
    IATA_Code_Operating_Airline,
    Tail_Number,
    Flight_Number_Operating_Airline,
    OriginAirportID,
    OriginAirportSeqID,
    OriginCityMarketID,
    OriginCityName,
    OriginState,
    OriginStateFips,
    OriginStateName,
    OriginWac,
    DestAirportID,
    DestAirportSeqID,
    DestCityMarketID,
    DestCityName,
    DestState,
    DestStateFips,
    DestStateName,
    DestWac,
    DepDel15,
    DepartureDelayGroups,
    DepTimeBlk,
    TaxiOut,
    CAST(concat_ws(' ',
        date_format(from_unixtime(CAST(FlightDate / 1000 AS BIGINT)), 'yyyy-MM-dd'),
        from_unixtime(CAST(WheelsOff / 1000 AS BIGINT), 'HH:mm:ss')
    ) AS TIMESTAMP) AS WheelsOff,
    CAST(concat_ws(' ',
        date_format(from_unixtime(CAST(FlightDate / 1000 AS BIGINT)), 'yyyy-MM-dd'),
        from_unixtime(CAST(WheelsOn / 1000 AS BIGINT), 'HH:mm:ss')
    ) AS TIMESTAMP) AS WheelsOn,
    TaxiIn,
    CAST(concat_ws(' ',
        date_format(from_unixtime(CAST(FlightDate / 1000 AS BIGINT)), 'yyyy-MM-dd'),
        from_unixtime(CAST(CRSArrTime / 1000 AS BIGINT), 'HH:mm:ss')
    ) AS TIMESTAMP) AS CRSArrTime,
    ArrDelay,
    ArrDel15,
    ArrivalDelayGroups,
    ArrTimeBlk,
    DistanceGroup,
    DivAirportLandings,
    Month
FROM flights_temp;


-- Drop temporary table without partitions
DROP TABLE flights_temp;
