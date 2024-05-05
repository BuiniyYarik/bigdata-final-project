-- Create function to format to HH24:MM time format
DROP FUNCTION format_time; 
CREATE OR REPLACE FUNCTION format_time(raw_time FLOAT) RETURNS VARCHAR AS $$
    DECLARE
        time_int INTEGER;
        time_text TEXT;
    BEGIN
        -- Convert float to integer safely
        time_int := raw_time::INTEGER;

        -- Adjust time if it's more than 2400 (invalid time)
        IF time_int >= 2400 THEN
            time_int := time_int - 2400;
        END IF;

        -- Convert integer to text and pad string for 4 digits length
	time_text := LPAD(time_int::TEXT, 4, '0');

        -- Return the time in HH24:MI format
        RETURN TO_CHAR(TO_TIMESTAMP(time_text, 'HH24MI'), 'HH24:MI');
    END;
$$ LANGUAGE plpgsql;


-- Import data from raw table and cast necessary fields types 
INSERT INTO flights
SELECT
    FlightDate,
    Airline,
    Origin,
    Dest,
    Cancelled::BOOLEAN AS Cancelled,
    Diverted::BOOLEAN AS Diverted,
    format_time(CRSDepTime) AS CRSDepTime,
    format_time(DepTime) AS DepTime,
    DepDelayMinutes::INTEGER AS DepDelayMinutes,
    DepDelay::INTEGER AS DepDelay,
    format_time(ArrTime) AS ArrTime,
    ArrDelayMinutes::INTEGER AS ArrDelayMinutes,
    AirTime::INTEGER AS AirTime,
    CRSElapsedTime::INTEGER AS CRSElapsedTime,
    ActualElapsedTime::INTEGER AS ActualElapsedTime,
    Distance::INTEGER AS Distance,
    Year,
    Quarter,
    Month,
    DayOfMonth,
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
    CAST(DepDel15 AS INTEGER)::BOOLEAN AS DepDel15,
    DepartureDelayGroups::INTEGER AS DepartureDelayGroups,
    DepTimeBlk,
    TaxiOut::INTEGER AS TaxiOut,
    format_time(WheelsOff) AS WheelsOff,  
    format_time(WheelsOn) AS WheelsOn,
    TaxiIn::INTEGER AS TaxiIn,
    format_time(CRSArrTime) AS CRSArrTime,
    ArrDelay::INTEGER AS ArrDelay,
    CAST(ArrDel15 AS INTEGER)::BOOLEAN AS ArrDel15,
    ArrivalDelayGroups::INTEGER AS ArrivalDelayGroups,
    ArrTimeBlk,
    DistanceGroup::INTEGER AS DistanceGroup,
    DivAirportLandings::INTEGER AS DivAirportLandings
FROM flights_raw;


-- Drop raw table
DROP TABLE flights_raw;
