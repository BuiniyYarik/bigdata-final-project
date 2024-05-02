// ORM class for table 'flights'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu May 02 21:09:25 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class flights extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("flightdate", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.flightdate = (java.sql.Date)value;
      }
    });
    setters.put("airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.airline = (String)value;
      }
    });
    setters.put("origin", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.origin = (String)value;
      }
    });
    setters.put("dest", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.dest = (String)value;
      }
    });
    setters.put("cancelled", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.cancelled = (Boolean)value;
      }
    });
    setters.put("diverted", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.diverted = (Boolean)value;
      }
    });
    setters.put("crsdeptime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.crsdeptime = (java.sql.Time)value;
      }
    });
    setters.put("deptime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.deptime = (java.sql.Time)value;
      }
    });
    setters.put("depdelayminutes", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.depdelayminutes = (Integer)value;
      }
    });
    setters.put("depdelay", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.depdelay = (Integer)value;
      }
    });
    setters.put("arrtime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.arrtime = (java.sql.Time)value;
      }
    });
    setters.put("arrdelayminutes", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.arrdelayminutes = (Integer)value;
      }
    });
    setters.put("airtime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.airtime = (Integer)value;
      }
    });
    setters.put("crselapsedtime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.crselapsedtime = (Integer)value;
      }
    });
    setters.put("actualelapsedtime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.actualelapsedtime = (Integer)value;
      }
    });
    setters.put("distance", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.distance = (Integer)value;
      }
    });
    setters.put("year", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.year = (Integer)value;
      }
    });
    setters.put("quarter", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.quarter = (Integer)value;
      }
    });
    setters.put("month", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.month = (Integer)value;
      }
    });
    setters.put("dayofmonth", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.dayofmonth = (Integer)value;
      }
    });
    setters.put("dayofweek", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.dayofweek = (Integer)value;
      }
    });
    setters.put("marketing_airline_network", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.marketing_airline_network = (String)value;
      }
    });
    setters.put("operated_or_branded_code_share_partners", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.operated_or_branded_code_share_partners = (String)value;
      }
    });
    setters.put("dot_id_marketing_airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.dot_id_marketing_airline = (Integer)value;
      }
    });
    setters.put("iata_code_marketing_airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.iata_code_marketing_airline = (String)value;
      }
    });
    setters.put("flight_number_marketing_airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.flight_number_marketing_airline = (String)value;
      }
    });
    setters.put("operating_airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.operating_airline = (String)value;
      }
    });
    setters.put("dot_id_operating_airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.dot_id_operating_airline = (Integer)value;
      }
    });
    setters.put("iata_code_operating_airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.iata_code_operating_airline = (String)value;
      }
    });
    setters.put("tail_number", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.tail_number = (String)value;
      }
    });
    setters.put("flight_number_operating_airline", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.flight_number_operating_airline = (String)value;
      }
    });
    setters.put("originairportid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.originairportid = (Integer)value;
      }
    });
    setters.put("originairportseqid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.originairportseqid = (Integer)value;
      }
    });
    setters.put("origincitymarketid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.origincitymarketid = (Integer)value;
      }
    });
    setters.put("origincityname", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.origincityname = (String)value;
      }
    });
    setters.put("originstate", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.originstate = (String)value;
      }
    });
    setters.put("originstatefips", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.originstatefips = (Integer)value;
      }
    });
    setters.put("originstatename", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.originstatename = (String)value;
      }
    });
    setters.put("originwac", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.originwac = (Integer)value;
      }
    });
    setters.put("destairportid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.destairportid = (Integer)value;
      }
    });
    setters.put("destairportseqid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.destairportseqid = (Integer)value;
      }
    });
    setters.put("destcitymarketid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.destcitymarketid = (Integer)value;
      }
    });
    setters.put("destcityname", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.destcityname = (String)value;
      }
    });
    setters.put("deststate", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.deststate = (String)value;
      }
    });
    setters.put("deststatefips", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.deststatefips = (Integer)value;
      }
    });
    setters.put("deststatename", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.deststatename = (String)value;
      }
    });
    setters.put("destwac", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.destwac = (Integer)value;
      }
    });
    setters.put("depdel15", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.depdel15 = (Boolean)value;
      }
    });
    setters.put("departuredelaygroups", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.departuredelaygroups = (Integer)value;
      }
    });
    setters.put("deptimeblk", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.deptimeblk = (String)value;
      }
    });
    setters.put("taxiout", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.taxiout = (Integer)value;
      }
    });
    setters.put("wheelsoff", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.wheelsoff = (java.sql.Time)value;
      }
    });
    setters.put("wheelson", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.wheelson = (java.sql.Time)value;
      }
    });
    setters.put("taxiin", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.taxiin = (Integer)value;
      }
    });
    setters.put("crsarrtime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.crsarrtime = (java.sql.Time)value;
      }
    });
    setters.put("arrdelay", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.arrdelay = (Integer)value;
      }
    });
    setters.put("arrdel15", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.arrdel15 = (Boolean)value;
      }
    });
    setters.put("arrivaldelaygroups", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.arrivaldelaygroups = (Integer)value;
      }
    });
    setters.put("arrtimeblk", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.arrtimeblk = (String)value;
      }
    });
    setters.put("distancegroup", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.distancegroup = (Integer)value;
      }
    });
    setters.put("divairportlandings", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        flights.this.divairportlandings = (Integer)value;
      }
    });
  }
  public flights() {
    init0();
  }
  private java.sql.Date flightdate;
  public java.sql.Date get_flightdate() {
    return flightdate;
  }
  public void set_flightdate(java.sql.Date flightdate) {
    this.flightdate = flightdate;
  }
  public flights with_flightdate(java.sql.Date flightdate) {
    this.flightdate = flightdate;
    return this;
  }
  private String airline;
  public String get_airline() {
    return airline;
  }
  public void set_airline(String airline) {
    this.airline = airline;
  }
  public flights with_airline(String airline) {
    this.airline = airline;
    return this;
  }
  private String origin;
  public String get_origin() {
    return origin;
  }
  public void set_origin(String origin) {
    this.origin = origin;
  }
  public flights with_origin(String origin) {
    this.origin = origin;
    return this;
  }
  private String dest;
  public String get_dest() {
    return dest;
  }
  public void set_dest(String dest) {
    this.dest = dest;
  }
  public flights with_dest(String dest) {
    this.dest = dest;
    return this;
  }
  private Boolean cancelled;
  public Boolean get_cancelled() {
    return cancelled;
  }
  public void set_cancelled(Boolean cancelled) {
    this.cancelled = cancelled;
  }
  public flights with_cancelled(Boolean cancelled) {
    this.cancelled = cancelled;
    return this;
  }
  private Boolean diverted;
  public Boolean get_diverted() {
    return diverted;
  }
  public void set_diverted(Boolean diverted) {
    this.diverted = diverted;
  }
  public flights with_diverted(Boolean diverted) {
    this.diverted = diverted;
    return this;
  }
  private java.sql.Time crsdeptime;
  public java.sql.Time get_crsdeptime() {
    return crsdeptime;
  }
  public void set_crsdeptime(java.sql.Time crsdeptime) {
    this.crsdeptime = crsdeptime;
  }
  public flights with_crsdeptime(java.sql.Time crsdeptime) {
    this.crsdeptime = crsdeptime;
    return this;
  }
  private java.sql.Time deptime;
  public java.sql.Time get_deptime() {
    return deptime;
  }
  public void set_deptime(java.sql.Time deptime) {
    this.deptime = deptime;
  }
  public flights with_deptime(java.sql.Time deptime) {
    this.deptime = deptime;
    return this;
  }
  private Integer depdelayminutes;
  public Integer get_depdelayminutes() {
    return depdelayminutes;
  }
  public void set_depdelayminutes(Integer depdelayminutes) {
    this.depdelayminutes = depdelayminutes;
  }
  public flights with_depdelayminutes(Integer depdelayminutes) {
    this.depdelayminutes = depdelayminutes;
    return this;
  }
  private Integer depdelay;
  public Integer get_depdelay() {
    return depdelay;
  }
  public void set_depdelay(Integer depdelay) {
    this.depdelay = depdelay;
  }
  public flights with_depdelay(Integer depdelay) {
    this.depdelay = depdelay;
    return this;
  }
  private java.sql.Time arrtime;
  public java.sql.Time get_arrtime() {
    return arrtime;
  }
  public void set_arrtime(java.sql.Time arrtime) {
    this.arrtime = arrtime;
  }
  public flights with_arrtime(java.sql.Time arrtime) {
    this.arrtime = arrtime;
    return this;
  }
  private Integer arrdelayminutes;
  public Integer get_arrdelayminutes() {
    return arrdelayminutes;
  }
  public void set_arrdelayminutes(Integer arrdelayminutes) {
    this.arrdelayminutes = arrdelayminutes;
  }
  public flights with_arrdelayminutes(Integer arrdelayminutes) {
    this.arrdelayminutes = arrdelayminutes;
    return this;
  }
  private Integer airtime;
  public Integer get_airtime() {
    return airtime;
  }
  public void set_airtime(Integer airtime) {
    this.airtime = airtime;
  }
  public flights with_airtime(Integer airtime) {
    this.airtime = airtime;
    return this;
  }
  private Integer crselapsedtime;
  public Integer get_crselapsedtime() {
    return crselapsedtime;
  }
  public void set_crselapsedtime(Integer crselapsedtime) {
    this.crselapsedtime = crselapsedtime;
  }
  public flights with_crselapsedtime(Integer crselapsedtime) {
    this.crselapsedtime = crselapsedtime;
    return this;
  }
  private Integer actualelapsedtime;
  public Integer get_actualelapsedtime() {
    return actualelapsedtime;
  }
  public void set_actualelapsedtime(Integer actualelapsedtime) {
    this.actualelapsedtime = actualelapsedtime;
  }
  public flights with_actualelapsedtime(Integer actualelapsedtime) {
    this.actualelapsedtime = actualelapsedtime;
    return this;
  }
  private Integer distance;
  public Integer get_distance() {
    return distance;
  }
  public void set_distance(Integer distance) {
    this.distance = distance;
  }
  public flights with_distance(Integer distance) {
    this.distance = distance;
    return this;
  }
  private Integer year;
  public Integer get_year() {
    return year;
  }
  public void set_year(Integer year) {
    this.year = year;
  }
  public flights with_year(Integer year) {
    this.year = year;
    return this;
  }
  private Integer quarter;
  public Integer get_quarter() {
    return quarter;
  }
  public void set_quarter(Integer quarter) {
    this.quarter = quarter;
  }
  public flights with_quarter(Integer quarter) {
    this.quarter = quarter;
    return this;
  }
  private Integer month;
  public Integer get_month() {
    return month;
  }
  public void set_month(Integer month) {
    this.month = month;
  }
  public flights with_month(Integer month) {
    this.month = month;
    return this;
  }
  private Integer dayofmonth;
  public Integer get_dayofmonth() {
    return dayofmonth;
  }
  public void set_dayofmonth(Integer dayofmonth) {
    this.dayofmonth = dayofmonth;
  }
  public flights with_dayofmonth(Integer dayofmonth) {
    this.dayofmonth = dayofmonth;
    return this;
  }
  private Integer dayofweek;
  public Integer get_dayofweek() {
    return dayofweek;
  }
  public void set_dayofweek(Integer dayofweek) {
    this.dayofweek = dayofweek;
  }
  public flights with_dayofweek(Integer dayofweek) {
    this.dayofweek = dayofweek;
    return this;
  }
  private String marketing_airline_network;
  public String get_marketing_airline_network() {
    return marketing_airline_network;
  }
  public void set_marketing_airline_network(String marketing_airline_network) {
    this.marketing_airline_network = marketing_airline_network;
  }
  public flights with_marketing_airline_network(String marketing_airline_network) {
    this.marketing_airline_network = marketing_airline_network;
    return this;
  }
  private String operated_or_branded_code_share_partners;
  public String get_operated_or_branded_code_share_partners() {
    return operated_or_branded_code_share_partners;
  }
  public void set_operated_or_branded_code_share_partners(String operated_or_branded_code_share_partners) {
    this.operated_or_branded_code_share_partners = operated_or_branded_code_share_partners;
  }
  public flights with_operated_or_branded_code_share_partners(String operated_or_branded_code_share_partners) {
    this.operated_or_branded_code_share_partners = operated_or_branded_code_share_partners;
    return this;
  }
  private Integer dot_id_marketing_airline;
  public Integer get_dot_id_marketing_airline() {
    return dot_id_marketing_airline;
  }
  public void set_dot_id_marketing_airline(Integer dot_id_marketing_airline) {
    this.dot_id_marketing_airline = dot_id_marketing_airline;
  }
  public flights with_dot_id_marketing_airline(Integer dot_id_marketing_airline) {
    this.dot_id_marketing_airline = dot_id_marketing_airline;
    return this;
  }
  private String iata_code_marketing_airline;
  public String get_iata_code_marketing_airline() {
    return iata_code_marketing_airline;
  }
  public void set_iata_code_marketing_airline(String iata_code_marketing_airline) {
    this.iata_code_marketing_airline = iata_code_marketing_airline;
  }
  public flights with_iata_code_marketing_airline(String iata_code_marketing_airline) {
    this.iata_code_marketing_airline = iata_code_marketing_airline;
    return this;
  }
  private String flight_number_marketing_airline;
  public String get_flight_number_marketing_airline() {
    return flight_number_marketing_airline;
  }
  public void set_flight_number_marketing_airline(String flight_number_marketing_airline) {
    this.flight_number_marketing_airline = flight_number_marketing_airline;
  }
  public flights with_flight_number_marketing_airline(String flight_number_marketing_airline) {
    this.flight_number_marketing_airline = flight_number_marketing_airline;
    return this;
  }
  private String operating_airline;
  public String get_operating_airline() {
    return operating_airline;
  }
  public void set_operating_airline(String operating_airline) {
    this.operating_airline = operating_airline;
  }
  public flights with_operating_airline(String operating_airline) {
    this.operating_airline = operating_airline;
    return this;
  }
  private Integer dot_id_operating_airline;
  public Integer get_dot_id_operating_airline() {
    return dot_id_operating_airline;
  }
  public void set_dot_id_operating_airline(Integer dot_id_operating_airline) {
    this.dot_id_operating_airline = dot_id_operating_airline;
  }
  public flights with_dot_id_operating_airline(Integer dot_id_operating_airline) {
    this.dot_id_operating_airline = dot_id_operating_airline;
    return this;
  }
  private String iata_code_operating_airline;
  public String get_iata_code_operating_airline() {
    return iata_code_operating_airline;
  }
  public void set_iata_code_operating_airline(String iata_code_operating_airline) {
    this.iata_code_operating_airline = iata_code_operating_airline;
  }
  public flights with_iata_code_operating_airline(String iata_code_operating_airline) {
    this.iata_code_operating_airline = iata_code_operating_airline;
    return this;
  }
  private String tail_number;
  public String get_tail_number() {
    return tail_number;
  }
  public void set_tail_number(String tail_number) {
    this.tail_number = tail_number;
  }
  public flights with_tail_number(String tail_number) {
    this.tail_number = tail_number;
    return this;
  }
  private String flight_number_operating_airline;
  public String get_flight_number_operating_airline() {
    return flight_number_operating_airline;
  }
  public void set_flight_number_operating_airline(String flight_number_operating_airline) {
    this.flight_number_operating_airline = flight_number_operating_airline;
  }
  public flights with_flight_number_operating_airline(String flight_number_operating_airline) {
    this.flight_number_operating_airline = flight_number_operating_airline;
    return this;
  }
  private Integer originairportid;
  public Integer get_originairportid() {
    return originairportid;
  }
  public void set_originairportid(Integer originairportid) {
    this.originairportid = originairportid;
  }
  public flights with_originairportid(Integer originairportid) {
    this.originairportid = originairportid;
    return this;
  }
  private Integer originairportseqid;
  public Integer get_originairportseqid() {
    return originairportseqid;
  }
  public void set_originairportseqid(Integer originairportseqid) {
    this.originairportseqid = originairportseqid;
  }
  public flights with_originairportseqid(Integer originairportseqid) {
    this.originairportseqid = originairportseqid;
    return this;
  }
  private Integer origincitymarketid;
  public Integer get_origincitymarketid() {
    return origincitymarketid;
  }
  public void set_origincitymarketid(Integer origincitymarketid) {
    this.origincitymarketid = origincitymarketid;
  }
  public flights with_origincitymarketid(Integer origincitymarketid) {
    this.origincitymarketid = origincitymarketid;
    return this;
  }
  private String origincityname;
  public String get_origincityname() {
    return origincityname;
  }
  public void set_origincityname(String origincityname) {
    this.origincityname = origincityname;
  }
  public flights with_origincityname(String origincityname) {
    this.origincityname = origincityname;
    return this;
  }
  private String originstate;
  public String get_originstate() {
    return originstate;
  }
  public void set_originstate(String originstate) {
    this.originstate = originstate;
  }
  public flights with_originstate(String originstate) {
    this.originstate = originstate;
    return this;
  }
  private Integer originstatefips;
  public Integer get_originstatefips() {
    return originstatefips;
  }
  public void set_originstatefips(Integer originstatefips) {
    this.originstatefips = originstatefips;
  }
  public flights with_originstatefips(Integer originstatefips) {
    this.originstatefips = originstatefips;
    return this;
  }
  private String originstatename;
  public String get_originstatename() {
    return originstatename;
  }
  public void set_originstatename(String originstatename) {
    this.originstatename = originstatename;
  }
  public flights with_originstatename(String originstatename) {
    this.originstatename = originstatename;
    return this;
  }
  private Integer originwac;
  public Integer get_originwac() {
    return originwac;
  }
  public void set_originwac(Integer originwac) {
    this.originwac = originwac;
  }
  public flights with_originwac(Integer originwac) {
    this.originwac = originwac;
    return this;
  }
  private Integer destairportid;
  public Integer get_destairportid() {
    return destairportid;
  }
  public void set_destairportid(Integer destairportid) {
    this.destairportid = destairportid;
  }
  public flights with_destairportid(Integer destairportid) {
    this.destairportid = destairportid;
    return this;
  }
  private Integer destairportseqid;
  public Integer get_destairportseqid() {
    return destairportseqid;
  }
  public void set_destairportseqid(Integer destairportseqid) {
    this.destairportseqid = destairportseqid;
  }
  public flights with_destairportseqid(Integer destairportseqid) {
    this.destairportseqid = destairportseqid;
    return this;
  }
  private Integer destcitymarketid;
  public Integer get_destcitymarketid() {
    return destcitymarketid;
  }
  public void set_destcitymarketid(Integer destcitymarketid) {
    this.destcitymarketid = destcitymarketid;
  }
  public flights with_destcitymarketid(Integer destcitymarketid) {
    this.destcitymarketid = destcitymarketid;
    return this;
  }
  private String destcityname;
  public String get_destcityname() {
    return destcityname;
  }
  public void set_destcityname(String destcityname) {
    this.destcityname = destcityname;
  }
  public flights with_destcityname(String destcityname) {
    this.destcityname = destcityname;
    return this;
  }
  private String deststate;
  public String get_deststate() {
    return deststate;
  }
  public void set_deststate(String deststate) {
    this.deststate = deststate;
  }
  public flights with_deststate(String deststate) {
    this.deststate = deststate;
    return this;
  }
  private Integer deststatefips;
  public Integer get_deststatefips() {
    return deststatefips;
  }
  public void set_deststatefips(Integer deststatefips) {
    this.deststatefips = deststatefips;
  }
  public flights with_deststatefips(Integer deststatefips) {
    this.deststatefips = deststatefips;
    return this;
  }
  private String deststatename;
  public String get_deststatename() {
    return deststatename;
  }
  public void set_deststatename(String deststatename) {
    this.deststatename = deststatename;
  }
  public flights with_deststatename(String deststatename) {
    this.deststatename = deststatename;
    return this;
  }
  private Integer destwac;
  public Integer get_destwac() {
    return destwac;
  }
  public void set_destwac(Integer destwac) {
    this.destwac = destwac;
  }
  public flights with_destwac(Integer destwac) {
    this.destwac = destwac;
    return this;
  }
  private Boolean depdel15;
  public Boolean get_depdel15() {
    return depdel15;
  }
  public void set_depdel15(Boolean depdel15) {
    this.depdel15 = depdel15;
  }
  public flights with_depdel15(Boolean depdel15) {
    this.depdel15 = depdel15;
    return this;
  }
  private Integer departuredelaygroups;
  public Integer get_departuredelaygroups() {
    return departuredelaygroups;
  }
  public void set_departuredelaygroups(Integer departuredelaygroups) {
    this.departuredelaygroups = departuredelaygroups;
  }
  public flights with_departuredelaygroups(Integer departuredelaygroups) {
    this.departuredelaygroups = departuredelaygroups;
    return this;
  }
  private String deptimeblk;
  public String get_deptimeblk() {
    return deptimeblk;
  }
  public void set_deptimeblk(String deptimeblk) {
    this.deptimeblk = deptimeblk;
  }
  public flights with_deptimeblk(String deptimeblk) {
    this.deptimeblk = deptimeblk;
    return this;
  }
  private Integer taxiout;
  public Integer get_taxiout() {
    return taxiout;
  }
  public void set_taxiout(Integer taxiout) {
    this.taxiout = taxiout;
  }
  public flights with_taxiout(Integer taxiout) {
    this.taxiout = taxiout;
    return this;
  }
  private java.sql.Time wheelsoff;
  public java.sql.Time get_wheelsoff() {
    return wheelsoff;
  }
  public void set_wheelsoff(java.sql.Time wheelsoff) {
    this.wheelsoff = wheelsoff;
  }
  public flights with_wheelsoff(java.sql.Time wheelsoff) {
    this.wheelsoff = wheelsoff;
    return this;
  }
  private java.sql.Time wheelson;
  public java.sql.Time get_wheelson() {
    return wheelson;
  }
  public void set_wheelson(java.sql.Time wheelson) {
    this.wheelson = wheelson;
  }
  public flights with_wheelson(java.sql.Time wheelson) {
    this.wheelson = wheelson;
    return this;
  }
  private Integer taxiin;
  public Integer get_taxiin() {
    return taxiin;
  }
  public void set_taxiin(Integer taxiin) {
    this.taxiin = taxiin;
  }
  public flights with_taxiin(Integer taxiin) {
    this.taxiin = taxiin;
    return this;
  }
  private java.sql.Time crsarrtime;
  public java.sql.Time get_crsarrtime() {
    return crsarrtime;
  }
  public void set_crsarrtime(java.sql.Time crsarrtime) {
    this.crsarrtime = crsarrtime;
  }
  public flights with_crsarrtime(java.sql.Time crsarrtime) {
    this.crsarrtime = crsarrtime;
    return this;
  }
  private Integer arrdelay;
  public Integer get_arrdelay() {
    return arrdelay;
  }
  public void set_arrdelay(Integer arrdelay) {
    this.arrdelay = arrdelay;
  }
  public flights with_arrdelay(Integer arrdelay) {
    this.arrdelay = arrdelay;
    return this;
  }
  private Boolean arrdel15;
  public Boolean get_arrdel15() {
    return arrdel15;
  }
  public void set_arrdel15(Boolean arrdel15) {
    this.arrdel15 = arrdel15;
  }
  public flights with_arrdel15(Boolean arrdel15) {
    this.arrdel15 = arrdel15;
    return this;
  }
  private Integer arrivaldelaygroups;
  public Integer get_arrivaldelaygroups() {
    return arrivaldelaygroups;
  }
  public void set_arrivaldelaygroups(Integer arrivaldelaygroups) {
    this.arrivaldelaygroups = arrivaldelaygroups;
  }
  public flights with_arrivaldelaygroups(Integer arrivaldelaygroups) {
    this.arrivaldelaygroups = arrivaldelaygroups;
    return this;
  }
  private String arrtimeblk;
  public String get_arrtimeblk() {
    return arrtimeblk;
  }
  public void set_arrtimeblk(String arrtimeblk) {
    this.arrtimeblk = arrtimeblk;
  }
  public flights with_arrtimeblk(String arrtimeblk) {
    this.arrtimeblk = arrtimeblk;
    return this;
  }
  private Integer distancegroup;
  public Integer get_distancegroup() {
    return distancegroup;
  }
  public void set_distancegroup(Integer distancegroup) {
    this.distancegroup = distancegroup;
  }
  public flights with_distancegroup(Integer distancegroup) {
    this.distancegroup = distancegroup;
    return this;
  }
  private Integer divairportlandings;
  public Integer get_divairportlandings() {
    return divairportlandings;
  }
  public void set_divairportlandings(Integer divairportlandings) {
    this.divairportlandings = divairportlandings;
  }
  public flights with_divairportlandings(Integer divairportlandings) {
    this.divairportlandings = divairportlandings;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof flights)) {
      return false;
    }
    flights that = (flights) o;
    boolean equal = true;
    equal = equal && (this.flightdate == null ? that.flightdate == null : this.flightdate.equals(that.flightdate));
    equal = equal && (this.airline == null ? that.airline == null : this.airline.equals(that.airline));
    equal = equal && (this.origin == null ? that.origin == null : this.origin.equals(that.origin));
    equal = equal && (this.dest == null ? that.dest == null : this.dest.equals(that.dest));
    equal = equal && (this.cancelled == null ? that.cancelled == null : this.cancelled.equals(that.cancelled));
    equal = equal && (this.diverted == null ? that.diverted == null : this.diverted.equals(that.diverted));
    equal = equal && (this.crsdeptime == null ? that.crsdeptime == null : this.crsdeptime.equals(that.crsdeptime));
    equal = equal && (this.deptime == null ? that.deptime == null : this.deptime.equals(that.deptime));
    equal = equal && (this.depdelayminutes == null ? that.depdelayminutes == null : this.depdelayminutes.equals(that.depdelayminutes));
    equal = equal && (this.depdelay == null ? that.depdelay == null : this.depdelay.equals(that.depdelay));
    equal = equal && (this.arrtime == null ? that.arrtime == null : this.arrtime.equals(that.arrtime));
    equal = equal && (this.arrdelayminutes == null ? that.arrdelayminutes == null : this.arrdelayminutes.equals(that.arrdelayminutes));
    equal = equal && (this.airtime == null ? that.airtime == null : this.airtime.equals(that.airtime));
    equal = equal && (this.crselapsedtime == null ? that.crselapsedtime == null : this.crselapsedtime.equals(that.crselapsedtime));
    equal = equal && (this.actualelapsedtime == null ? that.actualelapsedtime == null : this.actualelapsedtime.equals(that.actualelapsedtime));
    equal = equal && (this.distance == null ? that.distance == null : this.distance.equals(that.distance));
    equal = equal && (this.year == null ? that.year == null : this.year.equals(that.year));
    equal = equal && (this.quarter == null ? that.quarter == null : this.quarter.equals(that.quarter));
    equal = equal && (this.month == null ? that.month == null : this.month.equals(that.month));
    equal = equal && (this.dayofmonth == null ? that.dayofmonth == null : this.dayofmonth.equals(that.dayofmonth));
    equal = equal && (this.dayofweek == null ? that.dayofweek == null : this.dayofweek.equals(that.dayofweek));
    equal = equal && (this.marketing_airline_network == null ? that.marketing_airline_network == null : this.marketing_airline_network.equals(that.marketing_airline_network));
    equal = equal && (this.operated_or_branded_code_share_partners == null ? that.operated_or_branded_code_share_partners == null : this.operated_or_branded_code_share_partners.equals(that.operated_or_branded_code_share_partners));
    equal = equal && (this.dot_id_marketing_airline == null ? that.dot_id_marketing_airline == null : this.dot_id_marketing_airline.equals(that.dot_id_marketing_airline));
    equal = equal && (this.iata_code_marketing_airline == null ? that.iata_code_marketing_airline == null : this.iata_code_marketing_airline.equals(that.iata_code_marketing_airline));
    equal = equal && (this.flight_number_marketing_airline == null ? that.flight_number_marketing_airline == null : this.flight_number_marketing_airline.equals(that.flight_number_marketing_airline));
    equal = equal && (this.operating_airline == null ? that.operating_airline == null : this.operating_airline.equals(that.operating_airline));
    equal = equal && (this.dot_id_operating_airline == null ? that.dot_id_operating_airline == null : this.dot_id_operating_airline.equals(that.dot_id_operating_airline));
    equal = equal && (this.iata_code_operating_airline == null ? that.iata_code_operating_airline == null : this.iata_code_operating_airline.equals(that.iata_code_operating_airline));
    equal = equal && (this.tail_number == null ? that.tail_number == null : this.tail_number.equals(that.tail_number));
    equal = equal && (this.flight_number_operating_airline == null ? that.flight_number_operating_airline == null : this.flight_number_operating_airline.equals(that.flight_number_operating_airline));
    equal = equal && (this.originairportid == null ? that.originairportid == null : this.originairportid.equals(that.originairportid));
    equal = equal && (this.originairportseqid == null ? that.originairportseqid == null : this.originairportseqid.equals(that.originairportseqid));
    equal = equal && (this.origincitymarketid == null ? that.origincitymarketid == null : this.origincitymarketid.equals(that.origincitymarketid));
    equal = equal && (this.origincityname == null ? that.origincityname == null : this.origincityname.equals(that.origincityname));
    equal = equal && (this.originstate == null ? that.originstate == null : this.originstate.equals(that.originstate));
    equal = equal && (this.originstatefips == null ? that.originstatefips == null : this.originstatefips.equals(that.originstatefips));
    equal = equal && (this.originstatename == null ? that.originstatename == null : this.originstatename.equals(that.originstatename));
    equal = equal && (this.originwac == null ? that.originwac == null : this.originwac.equals(that.originwac));
    equal = equal && (this.destairportid == null ? that.destairportid == null : this.destairportid.equals(that.destairportid));
    equal = equal && (this.destairportseqid == null ? that.destairportseqid == null : this.destairportseqid.equals(that.destairportseqid));
    equal = equal && (this.destcitymarketid == null ? that.destcitymarketid == null : this.destcitymarketid.equals(that.destcitymarketid));
    equal = equal && (this.destcityname == null ? that.destcityname == null : this.destcityname.equals(that.destcityname));
    equal = equal && (this.deststate == null ? that.deststate == null : this.deststate.equals(that.deststate));
    equal = equal && (this.deststatefips == null ? that.deststatefips == null : this.deststatefips.equals(that.deststatefips));
    equal = equal && (this.deststatename == null ? that.deststatename == null : this.deststatename.equals(that.deststatename));
    equal = equal && (this.destwac == null ? that.destwac == null : this.destwac.equals(that.destwac));
    equal = equal && (this.depdel15 == null ? that.depdel15 == null : this.depdel15.equals(that.depdel15));
    equal = equal && (this.departuredelaygroups == null ? that.departuredelaygroups == null : this.departuredelaygroups.equals(that.departuredelaygroups));
    equal = equal && (this.deptimeblk == null ? that.deptimeblk == null : this.deptimeblk.equals(that.deptimeblk));
    equal = equal && (this.taxiout == null ? that.taxiout == null : this.taxiout.equals(that.taxiout));
    equal = equal && (this.wheelsoff == null ? that.wheelsoff == null : this.wheelsoff.equals(that.wheelsoff));
    equal = equal && (this.wheelson == null ? that.wheelson == null : this.wheelson.equals(that.wheelson));
    equal = equal && (this.taxiin == null ? that.taxiin == null : this.taxiin.equals(that.taxiin));
    equal = equal && (this.crsarrtime == null ? that.crsarrtime == null : this.crsarrtime.equals(that.crsarrtime));
    equal = equal && (this.arrdelay == null ? that.arrdelay == null : this.arrdelay.equals(that.arrdelay));
    equal = equal && (this.arrdel15 == null ? that.arrdel15 == null : this.arrdel15.equals(that.arrdel15));
    equal = equal && (this.arrivaldelaygroups == null ? that.arrivaldelaygroups == null : this.arrivaldelaygroups.equals(that.arrivaldelaygroups));
    equal = equal && (this.arrtimeblk == null ? that.arrtimeblk == null : this.arrtimeblk.equals(that.arrtimeblk));
    equal = equal && (this.distancegroup == null ? that.distancegroup == null : this.distancegroup.equals(that.distancegroup));
    equal = equal && (this.divairportlandings == null ? that.divairportlandings == null : this.divairportlandings.equals(that.divairportlandings));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof flights)) {
      return false;
    }
    flights that = (flights) o;
    boolean equal = true;
    equal = equal && (this.flightdate == null ? that.flightdate == null : this.flightdate.equals(that.flightdate));
    equal = equal && (this.airline == null ? that.airline == null : this.airline.equals(that.airline));
    equal = equal && (this.origin == null ? that.origin == null : this.origin.equals(that.origin));
    equal = equal && (this.dest == null ? that.dest == null : this.dest.equals(that.dest));
    equal = equal && (this.cancelled == null ? that.cancelled == null : this.cancelled.equals(that.cancelled));
    equal = equal && (this.diverted == null ? that.diverted == null : this.diverted.equals(that.diverted));
    equal = equal && (this.crsdeptime == null ? that.crsdeptime == null : this.crsdeptime.equals(that.crsdeptime));
    equal = equal && (this.deptime == null ? that.deptime == null : this.deptime.equals(that.deptime));
    equal = equal && (this.depdelayminutes == null ? that.depdelayminutes == null : this.depdelayminutes.equals(that.depdelayminutes));
    equal = equal && (this.depdelay == null ? that.depdelay == null : this.depdelay.equals(that.depdelay));
    equal = equal && (this.arrtime == null ? that.arrtime == null : this.arrtime.equals(that.arrtime));
    equal = equal && (this.arrdelayminutes == null ? that.arrdelayminutes == null : this.arrdelayminutes.equals(that.arrdelayminutes));
    equal = equal && (this.airtime == null ? that.airtime == null : this.airtime.equals(that.airtime));
    equal = equal && (this.crselapsedtime == null ? that.crselapsedtime == null : this.crselapsedtime.equals(that.crselapsedtime));
    equal = equal && (this.actualelapsedtime == null ? that.actualelapsedtime == null : this.actualelapsedtime.equals(that.actualelapsedtime));
    equal = equal && (this.distance == null ? that.distance == null : this.distance.equals(that.distance));
    equal = equal && (this.year == null ? that.year == null : this.year.equals(that.year));
    equal = equal && (this.quarter == null ? that.quarter == null : this.quarter.equals(that.quarter));
    equal = equal && (this.month == null ? that.month == null : this.month.equals(that.month));
    equal = equal && (this.dayofmonth == null ? that.dayofmonth == null : this.dayofmonth.equals(that.dayofmonth));
    equal = equal && (this.dayofweek == null ? that.dayofweek == null : this.dayofweek.equals(that.dayofweek));
    equal = equal && (this.marketing_airline_network == null ? that.marketing_airline_network == null : this.marketing_airline_network.equals(that.marketing_airline_network));
    equal = equal && (this.operated_or_branded_code_share_partners == null ? that.operated_or_branded_code_share_partners == null : this.operated_or_branded_code_share_partners.equals(that.operated_or_branded_code_share_partners));
    equal = equal && (this.dot_id_marketing_airline == null ? that.dot_id_marketing_airline == null : this.dot_id_marketing_airline.equals(that.dot_id_marketing_airline));
    equal = equal && (this.iata_code_marketing_airline == null ? that.iata_code_marketing_airline == null : this.iata_code_marketing_airline.equals(that.iata_code_marketing_airline));
    equal = equal && (this.flight_number_marketing_airline == null ? that.flight_number_marketing_airline == null : this.flight_number_marketing_airline.equals(that.flight_number_marketing_airline));
    equal = equal && (this.operating_airline == null ? that.operating_airline == null : this.operating_airline.equals(that.operating_airline));
    equal = equal && (this.dot_id_operating_airline == null ? that.dot_id_operating_airline == null : this.dot_id_operating_airline.equals(that.dot_id_operating_airline));
    equal = equal && (this.iata_code_operating_airline == null ? that.iata_code_operating_airline == null : this.iata_code_operating_airline.equals(that.iata_code_operating_airline));
    equal = equal && (this.tail_number == null ? that.tail_number == null : this.tail_number.equals(that.tail_number));
    equal = equal && (this.flight_number_operating_airline == null ? that.flight_number_operating_airline == null : this.flight_number_operating_airline.equals(that.flight_number_operating_airline));
    equal = equal && (this.originairportid == null ? that.originairportid == null : this.originairportid.equals(that.originairportid));
    equal = equal && (this.originairportseqid == null ? that.originairportseqid == null : this.originairportseqid.equals(that.originairportseqid));
    equal = equal && (this.origincitymarketid == null ? that.origincitymarketid == null : this.origincitymarketid.equals(that.origincitymarketid));
    equal = equal && (this.origincityname == null ? that.origincityname == null : this.origincityname.equals(that.origincityname));
    equal = equal && (this.originstate == null ? that.originstate == null : this.originstate.equals(that.originstate));
    equal = equal && (this.originstatefips == null ? that.originstatefips == null : this.originstatefips.equals(that.originstatefips));
    equal = equal && (this.originstatename == null ? that.originstatename == null : this.originstatename.equals(that.originstatename));
    equal = equal && (this.originwac == null ? that.originwac == null : this.originwac.equals(that.originwac));
    equal = equal && (this.destairportid == null ? that.destairportid == null : this.destairportid.equals(that.destairportid));
    equal = equal && (this.destairportseqid == null ? that.destairportseqid == null : this.destairportseqid.equals(that.destairportseqid));
    equal = equal && (this.destcitymarketid == null ? that.destcitymarketid == null : this.destcitymarketid.equals(that.destcitymarketid));
    equal = equal && (this.destcityname == null ? that.destcityname == null : this.destcityname.equals(that.destcityname));
    equal = equal && (this.deststate == null ? that.deststate == null : this.deststate.equals(that.deststate));
    equal = equal && (this.deststatefips == null ? that.deststatefips == null : this.deststatefips.equals(that.deststatefips));
    equal = equal && (this.deststatename == null ? that.deststatename == null : this.deststatename.equals(that.deststatename));
    equal = equal && (this.destwac == null ? that.destwac == null : this.destwac.equals(that.destwac));
    equal = equal && (this.depdel15 == null ? that.depdel15 == null : this.depdel15.equals(that.depdel15));
    equal = equal && (this.departuredelaygroups == null ? that.departuredelaygroups == null : this.departuredelaygroups.equals(that.departuredelaygroups));
    equal = equal && (this.deptimeblk == null ? that.deptimeblk == null : this.deptimeblk.equals(that.deptimeblk));
    equal = equal && (this.taxiout == null ? that.taxiout == null : this.taxiout.equals(that.taxiout));
    equal = equal && (this.wheelsoff == null ? that.wheelsoff == null : this.wheelsoff.equals(that.wheelsoff));
    equal = equal && (this.wheelson == null ? that.wheelson == null : this.wheelson.equals(that.wheelson));
    equal = equal && (this.taxiin == null ? that.taxiin == null : this.taxiin.equals(that.taxiin));
    equal = equal && (this.crsarrtime == null ? that.crsarrtime == null : this.crsarrtime.equals(that.crsarrtime));
    equal = equal && (this.arrdelay == null ? that.arrdelay == null : this.arrdelay.equals(that.arrdelay));
    equal = equal && (this.arrdel15 == null ? that.arrdel15 == null : this.arrdel15.equals(that.arrdel15));
    equal = equal && (this.arrivaldelaygroups == null ? that.arrivaldelaygroups == null : this.arrivaldelaygroups.equals(that.arrivaldelaygroups));
    equal = equal && (this.arrtimeblk == null ? that.arrtimeblk == null : this.arrtimeblk.equals(that.arrtimeblk));
    equal = equal && (this.distancegroup == null ? that.distancegroup == null : this.distancegroup.equals(that.distancegroup));
    equal = equal && (this.divairportlandings == null ? that.divairportlandings == null : this.divairportlandings.equals(that.divairportlandings));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.flightdate = JdbcWritableBridge.readDate(1, __dbResults);
    this.airline = JdbcWritableBridge.readString(2, __dbResults);
    this.origin = JdbcWritableBridge.readString(3, __dbResults);
    this.dest = JdbcWritableBridge.readString(4, __dbResults);
    this.cancelled = JdbcWritableBridge.readBoolean(5, __dbResults);
    this.diverted = JdbcWritableBridge.readBoolean(6, __dbResults);
    this.crsdeptime = JdbcWritableBridge.readTime(7, __dbResults);
    this.deptime = JdbcWritableBridge.readTime(8, __dbResults);
    this.depdelayminutes = JdbcWritableBridge.readInteger(9, __dbResults);
    this.depdelay = JdbcWritableBridge.readInteger(10, __dbResults);
    this.arrtime = JdbcWritableBridge.readTime(11, __dbResults);
    this.arrdelayminutes = JdbcWritableBridge.readInteger(12, __dbResults);
    this.airtime = JdbcWritableBridge.readInteger(13, __dbResults);
    this.crselapsedtime = JdbcWritableBridge.readInteger(14, __dbResults);
    this.actualelapsedtime = JdbcWritableBridge.readInteger(15, __dbResults);
    this.distance = JdbcWritableBridge.readInteger(16, __dbResults);
    this.year = JdbcWritableBridge.readInteger(17, __dbResults);
    this.quarter = JdbcWritableBridge.readInteger(18, __dbResults);
    this.month = JdbcWritableBridge.readInteger(19, __dbResults);
    this.dayofmonth = JdbcWritableBridge.readInteger(20, __dbResults);
    this.dayofweek = JdbcWritableBridge.readInteger(21, __dbResults);
    this.marketing_airline_network = JdbcWritableBridge.readString(22, __dbResults);
    this.operated_or_branded_code_share_partners = JdbcWritableBridge.readString(23, __dbResults);
    this.dot_id_marketing_airline = JdbcWritableBridge.readInteger(24, __dbResults);
    this.iata_code_marketing_airline = JdbcWritableBridge.readString(25, __dbResults);
    this.flight_number_marketing_airline = JdbcWritableBridge.readString(26, __dbResults);
    this.operating_airline = JdbcWritableBridge.readString(27, __dbResults);
    this.dot_id_operating_airline = JdbcWritableBridge.readInteger(28, __dbResults);
    this.iata_code_operating_airline = JdbcWritableBridge.readString(29, __dbResults);
    this.tail_number = JdbcWritableBridge.readString(30, __dbResults);
    this.flight_number_operating_airline = JdbcWritableBridge.readString(31, __dbResults);
    this.originairportid = JdbcWritableBridge.readInteger(32, __dbResults);
    this.originairportseqid = JdbcWritableBridge.readInteger(33, __dbResults);
    this.origincitymarketid = JdbcWritableBridge.readInteger(34, __dbResults);
    this.origincityname = JdbcWritableBridge.readString(35, __dbResults);
    this.originstate = JdbcWritableBridge.readString(36, __dbResults);
    this.originstatefips = JdbcWritableBridge.readInteger(37, __dbResults);
    this.originstatename = JdbcWritableBridge.readString(38, __dbResults);
    this.originwac = JdbcWritableBridge.readInteger(39, __dbResults);
    this.destairportid = JdbcWritableBridge.readInteger(40, __dbResults);
    this.destairportseqid = JdbcWritableBridge.readInteger(41, __dbResults);
    this.destcitymarketid = JdbcWritableBridge.readInteger(42, __dbResults);
    this.destcityname = JdbcWritableBridge.readString(43, __dbResults);
    this.deststate = JdbcWritableBridge.readString(44, __dbResults);
    this.deststatefips = JdbcWritableBridge.readInteger(45, __dbResults);
    this.deststatename = JdbcWritableBridge.readString(46, __dbResults);
    this.destwac = JdbcWritableBridge.readInteger(47, __dbResults);
    this.depdel15 = JdbcWritableBridge.readBoolean(48, __dbResults);
    this.departuredelaygroups = JdbcWritableBridge.readInteger(49, __dbResults);
    this.deptimeblk = JdbcWritableBridge.readString(50, __dbResults);
    this.taxiout = JdbcWritableBridge.readInteger(51, __dbResults);
    this.wheelsoff = JdbcWritableBridge.readTime(52, __dbResults);
    this.wheelson = JdbcWritableBridge.readTime(53, __dbResults);
    this.taxiin = JdbcWritableBridge.readInteger(54, __dbResults);
    this.crsarrtime = JdbcWritableBridge.readTime(55, __dbResults);
    this.arrdelay = JdbcWritableBridge.readInteger(56, __dbResults);
    this.arrdel15 = JdbcWritableBridge.readBoolean(57, __dbResults);
    this.arrivaldelaygroups = JdbcWritableBridge.readInteger(58, __dbResults);
    this.arrtimeblk = JdbcWritableBridge.readString(59, __dbResults);
    this.distancegroup = JdbcWritableBridge.readInteger(60, __dbResults);
    this.divairportlandings = JdbcWritableBridge.readInteger(61, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.flightdate = JdbcWritableBridge.readDate(1, __dbResults);
    this.airline = JdbcWritableBridge.readString(2, __dbResults);
    this.origin = JdbcWritableBridge.readString(3, __dbResults);
    this.dest = JdbcWritableBridge.readString(4, __dbResults);
    this.cancelled = JdbcWritableBridge.readBoolean(5, __dbResults);
    this.diverted = JdbcWritableBridge.readBoolean(6, __dbResults);
    this.crsdeptime = JdbcWritableBridge.readTime(7, __dbResults);
    this.deptime = JdbcWritableBridge.readTime(8, __dbResults);
    this.depdelayminutes = JdbcWritableBridge.readInteger(9, __dbResults);
    this.depdelay = JdbcWritableBridge.readInteger(10, __dbResults);
    this.arrtime = JdbcWritableBridge.readTime(11, __dbResults);
    this.arrdelayminutes = JdbcWritableBridge.readInteger(12, __dbResults);
    this.airtime = JdbcWritableBridge.readInteger(13, __dbResults);
    this.crselapsedtime = JdbcWritableBridge.readInteger(14, __dbResults);
    this.actualelapsedtime = JdbcWritableBridge.readInteger(15, __dbResults);
    this.distance = JdbcWritableBridge.readInteger(16, __dbResults);
    this.year = JdbcWritableBridge.readInteger(17, __dbResults);
    this.quarter = JdbcWritableBridge.readInteger(18, __dbResults);
    this.month = JdbcWritableBridge.readInteger(19, __dbResults);
    this.dayofmonth = JdbcWritableBridge.readInteger(20, __dbResults);
    this.dayofweek = JdbcWritableBridge.readInteger(21, __dbResults);
    this.marketing_airline_network = JdbcWritableBridge.readString(22, __dbResults);
    this.operated_or_branded_code_share_partners = JdbcWritableBridge.readString(23, __dbResults);
    this.dot_id_marketing_airline = JdbcWritableBridge.readInteger(24, __dbResults);
    this.iata_code_marketing_airline = JdbcWritableBridge.readString(25, __dbResults);
    this.flight_number_marketing_airline = JdbcWritableBridge.readString(26, __dbResults);
    this.operating_airline = JdbcWritableBridge.readString(27, __dbResults);
    this.dot_id_operating_airline = JdbcWritableBridge.readInteger(28, __dbResults);
    this.iata_code_operating_airline = JdbcWritableBridge.readString(29, __dbResults);
    this.tail_number = JdbcWritableBridge.readString(30, __dbResults);
    this.flight_number_operating_airline = JdbcWritableBridge.readString(31, __dbResults);
    this.originairportid = JdbcWritableBridge.readInteger(32, __dbResults);
    this.originairportseqid = JdbcWritableBridge.readInteger(33, __dbResults);
    this.origincitymarketid = JdbcWritableBridge.readInteger(34, __dbResults);
    this.origincityname = JdbcWritableBridge.readString(35, __dbResults);
    this.originstate = JdbcWritableBridge.readString(36, __dbResults);
    this.originstatefips = JdbcWritableBridge.readInteger(37, __dbResults);
    this.originstatename = JdbcWritableBridge.readString(38, __dbResults);
    this.originwac = JdbcWritableBridge.readInteger(39, __dbResults);
    this.destairportid = JdbcWritableBridge.readInteger(40, __dbResults);
    this.destairportseqid = JdbcWritableBridge.readInteger(41, __dbResults);
    this.destcitymarketid = JdbcWritableBridge.readInteger(42, __dbResults);
    this.destcityname = JdbcWritableBridge.readString(43, __dbResults);
    this.deststate = JdbcWritableBridge.readString(44, __dbResults);
    this.deststatefips = JdbcWritableBridge.readInteger(45, __dbResults);
    this.deststatename = JdbcWritableBridge.readString(46, __dbResults);
    this.destwac = JdbcWritableBridge.readInteger(47, __dbResults);
    this.depdel15 = JdbcWritableBridge.readBoolean(48, __dbResults);
    this.departuredelaygroups = JdbcWritableBridge.readInteger(49, __dbResults);
    this.deptimeblk = JdbcWritableBridge.readString(50, __dbResults);
    this.taxiout = JdbcWritableBridge.readInteger(51, __dbResults);
    this.wheelsoff = JdbcWritableBridge.readTime(52, __dbResults);
    this.wheelson = JdbcWritableBridge.readTime(53, __dbResults);
    this.taxiin = JdbcWritableBridge.readInteger(54, __dbResults);
    this.crsarrtime = JdbcWritableBridge.readTime(55, __dbResults);
    this.arrdelay = JdbcWritableBridge.readInteger(56, __dbResults);
    this.arrdel15 = JdbcWritableBridge.readBoolean(57, __dbResults);
    this.arrivaldelaygroups = JdbcWritableBridge.readInteger(58, __dbResults);
    this.arrtimeblk = JdbcWritableBridge.readString(59, __dbResults);
    this.distancegroup = JdbcWritableBridge.readInteger(60, __dbResults);
    this.divairportlandings = JdbcWritableBridge.readInteger(61, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeDate(flightdate, 1 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeString(airline, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(origin, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dest, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(cancelled, 5 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(diverted, 6 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeTime(crsdeptime, 7 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeTime(deptime, 8 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(depdelayminutes, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(depdelay, 10 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTime(arrtime, 11 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(arrdelayminutes, 12 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(airtime, 13 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(crselapsedtime, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(actualelapsedtime, 15 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(distance, 16 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(year, 17 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(quarter, 18 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(month, 19 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(dayofmonth, 20 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(dayofweek, 21 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(marketing_airline_network, 22 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(operated_or_branded_code_share_partners, 23 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(dot_id_marketing_airline, 24 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(iata_code_marketing_airline, 25 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(flight_number_marketing_airline, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(operating_airline, 27 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(dot_id_operating_airline, 28 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(iata_code_operating_airline, 29 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(tail_number, 30 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(flight_number_operating_airline, 31 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(originairportid, 32 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(originairportseqid, 33 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(origincitymarketid, 34 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(origincityname, 35 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(originstate, 36 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(originstatefips, 37 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(originstatename, 38 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(originwac, 39 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(destairportid, 40 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(destairportseqid, 41 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(destcitymarketid, 42 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(destcityname, 43 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(deststate, 44 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(deststatefips, 45 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(deststatename, 46 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(destwac, 47 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBoolean(depdel15, 48 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(departuredelaygroups, 49 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(deptimeblk, 50 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(taxiout, 51 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTime(wheelsoff, 52 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeTime(wheelson, 53 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(taxiin, 54 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTime(crsarrtime, 55 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(arrdelay, 56 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBoolean(arrdel15, 57 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(arrivaldelaygroups, 58 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(arrtimeblk, 59 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(distancegroup, 60 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(divairportlandings, 61 + __off, 4, __dbStmt);
    return 61;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeDate(flightdate, 1 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeString(airline, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(origin, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dest, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(cancelled, 5 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(diverted, 6 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeTime(crsdeptime, 7 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeTime(deptime, 8 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(depdelayminutes, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(depdelay, 10 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTime(arrtime, 11 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(arrdelayminutes, 12 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(airtime, 13 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(crselapsedtime, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(actualelapsedtime, 15 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(distance, 16 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(year, 17 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(quarter, 18 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(month, 19 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(dayofmonth, 20 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(dayofweek, 21 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(marketing_airline_network, 22 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(operated_or_branded_code_share_partners, 23 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(dot_id_marketing_airline, 24 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(iata_code_marketing_airline, 25 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(flight_number_marketing_airline, 26 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(operating_airline, 27 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(dot_id_operating_airline, 28 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(iata_code_operating_airline, 29 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(tail_number, 30 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(flight_number_operating_airline, 31 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(originairportid, 32 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(originairportseqid, 33 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(origincitymarketid, 34 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(origincityname, 35 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(originstate, 36 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(originstatefips, 37 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(originstatename, 38 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(originwac, 39 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(destairportid, 40 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(destairportseqid, 41 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(destcitymarketid, 42 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(destcityname, 43 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(deststate, 44 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(deststatefips, 45 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(deststatename, 46 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(destwac, 47 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBoolean(depdel15, 48 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(departuredelaygroups, 49 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(deptimeblk, 50 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(taxiout, 51 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTime(wheelsoff, 52 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeTime(wheelson, 53 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(taxiin, 54 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTime(crsarrtime, 55 + __off, 92, __dbStmt);
    JdbcWritableBridge.writeInteger(arrdelay, 56 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBoolean(arrdel15, 57 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(arrivaldelaygroups, 58 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(arrtimeblk, 59 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(distancegroup, 60 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(divairportlandings, 61 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.flightdate = null;
    } else {
    this.flightdate = new Date(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.airline = null;
    } else {
    this.airline = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.origin = null;
    } else {
    this.origin = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dest = null;
    } else {
    this.dest = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.cancelled = null;
    } else {
    this.cancelled = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.diverted = null;
    } else {
    this.diverted = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.crsdeptime = null;
    } else {
    this.crsdeptime = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.deptime = null;
    } else {
    this.deptime = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.depdelayminutes = null;
    } else {
    this.depdelayminutes = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.depdelay = null;
    } else {
    this.depdelay = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.arrtime = null;
    } else {
    this.arrtime = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.arrdelayminutes = null;
    } else {
    this.arrdelayminutes = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.airtime = null;
    } else {
    this.airtime = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.crselapsedtime = null;
    } else {
    this.crselapsedtime = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.actualelapsedtime = null;
    } else {
    this.actualelapsedtime = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.distance = null;
    } else {
    this.distance = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.year = null;
    } else {
    this.year = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.quarter = null;
    } else {
    this.quarter = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.month = null;
    } else {
    this.month = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.dayofmonth = null;
    } else {
    this.dayofmonth = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.dayofweek = null;
    } else {
    this.dayofweek = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.marketing_airline_network = null;
    } else {
    this.marketing_airline_network = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.operated_or_branded_code_share_partners = null;
    } else {
    this.operated_or_branded_code_share_partners = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dot_id_marketing_airline = null;
    } else {
    this.dot_id_marketing_airline = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.iata_code_marketing_airline = null;
    } else {
    this.iata_code_marketing_airline = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.flight_number_marketing_airline = null;
    } else {
    this.flight_number_marketing_airline = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.operating_airline = null;
    } else {
    this.operating_airline = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dot_id_operating_airline = null;
    } else {
    this.dot_id_operating_airline = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.iata_code_operating_airline = null;
    } else {
    this.iata_code_operating_airline = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.tail_number = null;
    } else {
    this.tail_number = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.flight_number_operating_airline = null;
    } else {
    this.flight_number_operating_airline = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.originairportid = null;
    } else {
    this.originairportid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.originairportseqid = null;
    } else {
    this.originairportseqid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.origincitymarketid = null;
    } else {
    this.origincitymarketid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.origincityname = null;
    } else {
    this.origincityname = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.originstate = null;
    } else {
    this.originstate = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.originstatefips = null;
    } else {
    this.originstatefips = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.originstatename = null;
    } else {
    this.originstatename = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.originwac = null;
    } else {
    this.originwac = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.destairportid = null;
    } else {
    this.destairportid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.destairportseqid = null;
    } else {
    this.destairportseqid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.destcitymarketid = null;
    } else {
    this.destcitymarketid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.destcityname = null;
    } else {
    this.destcityname = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.deststate = null;
    } else {
    this.deststate = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.deststatefips = null;
    } else {
    this.deststatefips = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.deststatename = null;
    } else {
    this.deststatename = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.destwac = null;
    } else {
    this.destwac = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.depdel15 = null;
    } else {
    this.depdel15 = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.departuredelaygroups = null;
    } else {
    this.departuredelaygroups = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.deptimeblk = null;
    } else {
    this.deptimeblk = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.taxiout = null;
    } else {
    this.taxiout = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.wheelsoff = null;
    } else {
    this.wheelsoff = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.wheelson = null;
    } else {
    this.wheelson = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.taxiin = null;
    } else {
    this.taxiin = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.crsarrtime = null;
    } else {
    this.crsarrtime = new Time(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.arrdelay = null;
    } else {
    this.arrdelay = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.arrdel15 = null;
    } else {
    this.arrdel15 = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.arrivaldelaygroups = null;
    } else {
    this.arrivaldelaygroups = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.arrtimeblk = null;
    } else {
    this.arrtimeblk = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.distancegroup = null;
    } else {
    this.distancegroup = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.divairportlandings = null;
    } else {
    this.divairportlandings = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.flightdate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.flightdate.getTime());
    }
    if (null == this.airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, airline);
    }
    if (null == this.origin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origin);
    }
    if (null == this.dest) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dest);
    }
    if (null == this.cancelled) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.cancelled);
    }
    if (null == this.diverted) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.diverted);
    }
    if (null == this.crsdeptime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.crsdeptime.getTime());
    }
    if (null == this.deptime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.deptime.getTime());
    }
    if (null == this.depdelayminutes) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.depdelayminutes);
    }
    if (null == this.depdelay) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.depdelay);
    }
    if (null == this.arrtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.arrtime.getTime());
    }
    if (null == this.arrdelayminutes) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.arrdelayminutes);
    }
    if (null == this.airtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.airtime);
    }
    if (null == this.crselapsedtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.crselapsedtime);
    }
    if (null == this.actualelapsedtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.actualelapsedtime);
    }
    if (null == this.distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.distance);
    }
    if (null == this.year) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.year);
    }
    if (null == this.quarter) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.quarter);
    }
    if (null == this.month) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.month);
    }
    if (null == this.dayofmonth) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dayofmonth);
    }
    if (null == this.dayofweek) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dayofweek);
    }
    if (null == this.marketing_airline_network) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, marketing_airline_network);
    }
    if (null == this.operated_or_branded_code_share_partners) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, operated_or_branded_code_share_partners);
    }
    if (null == this.dot_id_marketing_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dot_id_marketing_airline);
    }
    if (null == this.iata_code_marketing_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, iata_code_marketing_airline);
    }
    if (null == this.flight_number_marketing_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, flight_number_marketing_airline);
    }
    if (null == this.operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, operating_airline);
    }
    if (null == this.dot_id_operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dot_id_operating_airline);
    }
    if (null == this.iata_code_operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, iata_code_operating_airline);
    }
    if (null == this.tail_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, tail_number);
    }
    if (null == this.flight_number_operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, flight_number_operating_airline);
    }
    if (null == this.originairportid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originairportid);
    }
    if (null == this.originairportseqid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originairportseqid);
    }
    if (null == this.origincitymarketid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.origincitymarketid);
    }
    if (null == this.origincityname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origincityname);
    }
    if (null == this.originstate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, originstate);
    }
    if (null == this.originstatefips) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originstatefips);
    }
    if (null == this.originstatename) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, originstatename);
    }
    if (null == this.originwac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originwac);
    }
    if (null == this.destairportid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destairportid);
    }
    if (null == this.destairportseqid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destairportseqid);
    }
    if (null == this.destcitymarketid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destcitymarketid);
    }
    if (null == this.destcityname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, destcityname);
    }
    if (null == this.deststate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deststate);
    }
    if (null == this.deststatefips) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.deststatefips);
    }
    if (null == this.deststatename) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deststatename);
    }
    if (null == this.destwac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destwac);
    }
    if (null == this.depdel15) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.depdel15);
    }
    if (null == this.departuredelaygroups) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.departuredelaygroups);
    }
    if (null == this.deptimeblk) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deptimeblk);
    }
    if (null == this.taxiout) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.taxiout);
    }
    if (null == this.wheelsoff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.wheelsoff.getTime());
    }
    if (null == this.wheelson) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.wheelson.getTime());
    }
    if (null == this.taxiin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.taxiin);
    }
    if (null == this.crsarrtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.crsarrtime.getTime());
    }
    if (null == this.arrdelay) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.arrdelay);
    }
    if (null == this.arrdel15) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.arrdel15);
    }
    if (null == this.arrivaldelaygroups) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.arrivaldelaygroups);
    }
    if (null == this.arrtimeblk) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, arrtimeblk);
    }
    if (null == this.distancegroup) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.distancegroup);
    }
    if (null == this.divairportlandings) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.divairportlandings);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.flightdate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.flightdate.getTime());
    }
    if (null == this.airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, airline);
    }
    if (null == this.origin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origin);
    }
    if (null == this.dest) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dest);
    }
    if (null == this.cancelled) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.cancelled);
    }
    if (null == this.diverted) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.diverted);
    }
    if (null == this.crsdeptime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.crsdeptime.getTime());
    }
    if (null == this.deptime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.deptime.getTime());
    }
    if (null == this.depdelayminutes) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.depdelayminutes);
    }
    if (null == this.depdelay) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.depdelay);
    }
    if (null == this.arrtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.arrtime.getTime());
    }
    if (null == this.arrdelayminutes) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.arrdelayminutes);
    }
    if (null == this.airtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.airtime);
    }
    if (null == this.crselapsedtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.crselapsedtime);
    }
    if (null == this.actualelapsedtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.actualelapsedtime);
    }
    if (null == this.distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.distance);
    }
    if (null == this.year) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.year);
    }
    if (null == this.quarter) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.quarter);
    }
    if (null == this.month) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.month);
    }
    if (null == this.dayofmonth) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dayofmonth);
    }
    if (null == this.dayofweek) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dayofweek);
    }
    if (null == this.marketing_airline_network) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, marketing_airline_network);
    }
    if (null == this.operated_or_branded_code_share_partners) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, operated_or_branded_code_share_partners);
    }
    if (null == this.dot_id_marketing_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dot_id_marketing_airline);
    }
    if (null == this.iata_code_marketing_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, iata_code_marketing_airline);
    }
    if (null == this.flight_number_marketing_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, flight_number_marketing_airline);
    }
    if (null == this.operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, operating_airline);
    }
    if (null == this.dot_id_operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.dot_id_operating_airline);
    }
    if (null == this.iata_code_operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, iata_code_operating_airline);
    }
    if (null == this.tail_number) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, tail_number);
    }
    if (null == this.flight_number_operating_airline) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, flight_number_operating_airline);
    }
    if (null == this.originairportid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originairportid);
    }
    if (null == this.originairportseqid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originairportseqid);
    }
    if (null == this.origincitymarketid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.origincitymarketid);
    }
    if (null == this.origincityname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origincityname);
    }
    if (null == this.originstate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, originstate);
    }
    if (null == this.originstatefips) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originstatefips);
    }
    if (null == this.originstatename) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, originstatename);
    }
    if (null == this.originwac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.originwac);
    }
    if (null == this.destairportid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destairportid);
    }
    if (null == this.destairportseqid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destairportseqid);
    }
    if (null == this.destcitymarketid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destcitymarketid);
    }
    if (null == this.destcityname) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, destcityname);
    }
    if (null == this.deststate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deststate);
    }
    if (null == this.deststatefips) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.deststatefips);
    }
    if (null == this.deststatename) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deststatename);
    }
    if (null == this.destwac) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.destwac);
    }
    if (null == this.depdel15) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.depdel15);
    }
    if (null == this.departuredelaygroups) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.departuredelaygroups);
    }
    if (null == this.deptimeblk) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, deptimeblk);
    }
    if (null == this.taxiout) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.taxiout);
    }
    if (null == this.wheelsoff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.wheelsoff.getTime());
    }
    if (null == this.wheelson) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.wheelson.getTime());
    }
    if (null == this.taxiin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.taxiin);
    }
    if (null == this.crsarrtime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.crsarrtime.getTime());
    }
    if (null == this.arrdelay) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.arrdelay);
    }
    if (null == this.arrdel15) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.arrdel15);
    }
    if (null == this.arrivaldelaygroups) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.arrivaldelaygroups);
    }
    if (null == this.arrtimeblk) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, arrtimeblk);
    }
    if (null == this.distancegroup) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.distancegroup);
    }
    if (null == this.divairportlandings) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.divairportlandings);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(flightdate==null?"null":"" + flightdate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(airline==null?"null":airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origin==null?"null":origin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dest==null?"null":dest, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cancelled==null?"null":"" + cancelled, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(diverted==null?"null":"" + diverted, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(crsdeptime==null?"null":"" + crsdeptime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deptime==null?"null":"" + deptime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(depdelayminutes==null?"null":"" + depdelayminutes, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(depdelay==null?"null":"" + depdelay, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrtime==null?"null":"" + arrtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrdelayminutes==null?"null":"" + arrdelayminutes, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(airtime==null?"null":"" + airtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(crselapsedtime==null?"null":"" + crselapsedtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(actualelapsedtime==null?"null":"" + actualelapsedtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(distance==null?"null":"" + distance, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(year==null?"null":"" + year, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(quarter==null?"null":"" + quarter, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(month==null?"null":"" + month, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dayofmonth==null?"null":"" + dayofmonth, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dayofweek==null?"null":"" + dayofweek, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(marketing_airline_network==null?"null":marketing_airline_network, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(operated_or_branded_code_share_partners==null?"null":operated_or_branded_code_share_partners, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dot_id_marketing_airline==null?"null":"" + dot_id_marketing_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(iata_code_marketing_airline==null?"null":iata_code_marketing_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(flight_number_marketing_airline==null?"null":flight_number_marketing_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(operating_airline==null?"null":operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dot_id_operating_airline==null?"null":"" + dot_id_operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(iata_code_operating_airline==null?"null":iata_code_operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tail_number==null?"null":tail_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(flight_number_operating_airline==null?"null":flight_number_operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originairportid==null?"null":"" + originairportid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originairportseqid==null?"null":"" + originairportseqid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origincitymarketid==null?"null":"" + origincitymarketid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origincityname==null?"null":origincityname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originstate==null?"null":originstate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originstatefips==null?"null":"" + originstatefips, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originstatename==null?"null":originstatename, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originwac==null?"null":"" + originwac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destairportid==null?"null":"" + destairportid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destairportseqid==null?"null":"" + destairportseqid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destcitymarketid==null?"null":"" + destcitymarketid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destcityname==null?"null":destcityname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deststate==null?"null":deststate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deststatefips==null?"null":"" + deststatefips, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deststatename==null?"null":deststatename, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destwac==null?"null":"" + destwac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(depdel15==null?"null":"" + depdel15, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(departuredelaygroups==null?"null":"" + departuredelaygroups, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deptimeblk==null?"null":deptimeblk, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(taxiout==null?"null":"" + taxiout, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wheelsoff==null?"null":"" + wheelsoff, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wheelson==null?"null":"" + wheelson, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(taxiin==null?"null":"" + taxiin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(crsarrtime==null?"null":"" + crsarrtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrdelay==null?"null":"" + arrdelay, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrdel15==null?"null":"" + arrdel15, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrivaldelaygroups==null?"null":"" + arrivaldelaygroups, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrtimeblk==null?"null":arrtimeblk, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(distancegroup==null?"null":"" + distancegroup, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(divairportlandings==null?"null":"" + divairportlandings, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(flightdate==null?"null":"" + flightdate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(airline==null?"null":airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origin==null?"null":origin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dest==null?"null":dest, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cancelled==null?"null":"" + cancelled, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(diverted==null?"null":"" + diverted, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(crsdeptime==null?"null":"" + crsdeptime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deptime==null?"null":"" + deptime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(depdelayminutes==null?"null":"" + depdelayminutes, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(depdelay==null?"null":"" + depdelay, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrtime==null?"null":"" + arrtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrdelayminutes==null?"null":"" + arrdelayminutes, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(airtime==null?"null":"" + airtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(crselapsedtime==null?"null":"" + crselapsedtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(actualelapsedtime==null?"null":"" + actualelapsedtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(distance==null?"null":"" + distance, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(year==null?"null":"" + year, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(quarter==null?"null":"" + quarter, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(month==null?"null":"" + month, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dayofmonth==null?"null":"" + dayofmonth, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dayofweek==null?"null":"" + dayofweek, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(marketing_airline_network==null?"null":marketing_airline_network, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(operated_or_branded_code_share_partners==null?"null":operated_or_branded_code_share_partners, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dot_id_marketing_airline==null?"null":"" + dot_id_marketing_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(iata_code_marketing_airline==null?"null":iata_code_marketing_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(flight_number_marketing_airline==null?"null":flight_number_marketing_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(operating_airline==null?"null":operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dot_id_operating_airline==null?"null":"" + dot_id_operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(iata_code_operating_airline==null?"null":iata_code_operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tail_number==null?"null":tail_number, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(flight_number_operating_airline==null?"null":flight_number_operating_airline, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originairportid==null?"null":"" + originairportid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originairportseqid==null?"null":"" + originairportseqid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origincitymarketid==null?"null":"" + origincitymarketid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origincityname==null?"null":origincityname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originstate==null?"null":originstate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originstatefips==null?"null":"" + originstatefips, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originstatename==null?"null":originstatename, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(originwac==null?"null":"" + originwac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destairportid==null?"null":"" + destairportid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destairportseqid==null?"null":"" + destairportseqid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destcitymarketid==null?"null":"" + destcitymarketid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destcityname==null?"null":destcityname, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deststate==null?"null":deststate, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deststatefips==null?"null":"" + deststatefips, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deststatename==null?"null":deststatename, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(destwac==null?"null":"" + destwac, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(depdel15==null?"null":"" + depdel15, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(departuredelaygroups==null?"null":"" + departuredelaygroups, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(deptimeblk==null?"null":deptimeblk, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(taxiout==null?"null":"" + taxiout, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wheelsoff==null?"null":"" + wheelsoff, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wheelson==null?"null":"" + wheelson, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(taxiin==null?"null":"" + taxiin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(crsarrtime==null?"null":"" + crsarrtime, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrdelay==null?"null":"" + arrdelay, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrdel15==null?"null":"" + arrdel15, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrivaldelaygroups==null?"null":"" + arrivaldelaygroups, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(arrtimeblk==null?"null":arrtimeblk, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(distancegroup==null?"null":"" + distancegroup, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(divairportlandings==null?"null":"" + divairportlandings, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.flightdate = null; } else {
      this.flightdate = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.airline = null; } else {
      this.airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.origin = null; } else {
      this.origin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dest = null; } else {
      this.dest = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cancelled = null; } else {
      this.cancelled = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.diverted = null; } else {
      this.diverted = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.crsdeptime = null; } else {
      this.crsdeptime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.deptime = null; } else {
      this.deptime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.depdelayminutes = null; } else {
      this.depdelayminutes = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.depdelay = null; } else {
      this.depdelay = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrtime = null; } else {
      this.arrtime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrdelayminutes = null; } else {
      this.arrdelayminutes = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.airtime = null; } else {
      this.airtime = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.crselapsedtime = null; } else {
      this.crselapsedtime = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.actualelapsedtime = null; } else {
      this.actualelapsedtime = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.distance = null; } else {
      this.distance = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.year = null; } else {
      this.year = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.quarter = null; } else {
      this.quarter = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.month = null; } else {
      this.month = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dayofmonth = null; } else {
      this.dayofmonth = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dayofweek = null; } else {
      this.dayofweek = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.marketing_airline_network = null; } else {
      this.marketing_airline_network = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.operated_or_branded_code_share_partners = null; } else {
      this.operated_or_branded_code_share_partners = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dot_id_marketing_airline = null; } else {
      this.dot_id_marketing_airline = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.iata_code_marketing_airline = null; } else {
      this.iata_code_marketing_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.flight_number_marketing_airline = null; } else {
      this.flight_number_marketing_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.operating_airline = null; } else {
      this.operating_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dot_id_operating_airline = null; } else {
      this.dot_id_operating_airline = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.iata_code_operating_airline = null; } else {
      this.iata_code_operating_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.tail_number = null; } else {
      this.tail_number = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.flight_number_operating_airline = null; } else {
      this.flight_number_operating_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originairportid = null; } else {
      this.originairportid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originairportseqid = null; } else {
      this.originairportseqid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.origincitymarketid = null; } else {
      this.origincitymarketid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.origincityname = null; } else {
      this.origincityname = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.originstate = null; } else {
      this.originstate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originstatefips = null; } else {
      this.originstatefips = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.originstatename = null; } else {
      this.originstatename = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originwac = null; } else {
      this.originwac = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destairportid = null; } else {
      this.destairportid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destairportseqid = null; } else {
      this.destairportseqid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destcitymarketid = null; } else {
      this.destcitymarketid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.destcityname = null; } else {
      this.destcityname = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.deststate = null; } else {
      this.deststate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.deststatefips = null; } else {
      this.deststatefips = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.deststatename = null; } else {
      this.deststatename = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destwac = null; } else {
      this.destwac = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.depdel15 = null; } else {
      this.depdel15 = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.departuredelaygroups = null; } else {
      this.departuredelaygroups = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.deptimeblk = null; } else {
      this.deptimeblk = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.taxiout = null; } else {
      this.taxiout = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wheelsoff = null; } else {
      this.wheelsoff = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wheelson = null; } else {
      this.wheelson = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.taxiin = null; } else {
      this.taxiin = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.crsarrtime = null; } else {
      this.crsarrtime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrdelay = null; } else {
      this.arrdelay = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrdel15 = null; } else {
      this.arrdel15 = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrivaldelaygroups = null; } else {
      this.arrivaldelaygroups = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.arrtimeblk = null; } else {
      this.arrtimeblk = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.distancegroup = null; } else {
      this.distancegroup = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.divairportlandings = null; } else {
      this.divairportlandings = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.flightdate = null; } else {
      this.flightdate = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.airline = null; } else {
      this.airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.origin = null; } else {
      this.origin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dest = null; } else {
      this.dest = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cancelled = null; } else {
      this.cancelled = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.diverted = null; } else {
      this.diverted = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.crsdeptime = null; } else {
      this.crsdeptime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.deptime = null; } else {
      this.deptime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.depdelayminutes = null; } else {
      this.depdelayminutes = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.depdelay = null; } else {
      this.depdelay = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrtime = null; } else {
      this.arrtime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrdelayminutes = null; } else {
      this.arrdelayminutes = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.airtime = null; } else {
      this.airtime = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.crselapsedtime = null; } else {
      this.crselapsedtime = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.actualelapsedtime = null; } else {
      this.actualelapsedtime = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.distance = null; } else {
      this.distance = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.year = null; } else {
      this.year = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.quarter = null; } else {
      this.quarter = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.month = null; } else {
      this.month = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dayofmonth = null; } else {
      this.dayofmonth = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dayofweek = null; } else {
      this.dayofweek = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.marketing_airline_network = null; } else {
      this.marketing_airline_network = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.operated_or_branded_code_share_partners = null; } else {
      this.operated_or_branded_code_share_partners = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dot_id_marketing_airline = null; } else {
      this.dot_id_marketing_airline = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.iata_code_marketing_airline = null; } else {
      this.iata_code_marketing_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.flight_number_marketing_airline = null; } else {
      this.flight_number_marketing_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.operating_airline = null; } else {
      this.operating_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dot_id_operating_airline = null; } else {
      this.dot_id_operating_airline = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.iata_code_operating_airline = null; } else {
      this.iata_code_operating_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.tail_number = null; } else {
      this.tail_number = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.flight_number_operating_airline = null; } else {
      this.flight_number_operating_airline = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originairportid = null; } else {
      this.originairportid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originairportseqid = null; } else {
      this.originairportseqid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.origincitymarketid = null; } else {
      this.origincitymarketid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.origincityname = null; } else {
      this.origincityname = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.originstate = null; } else {
      this.originstate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originstatefips = null; } else {
      this.originstatefips = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.originstatename = null; } else {
      this.originstatename = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.originwac = null; } else {
      this.originwac = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destairportid = null; } else {
      this.destairportid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destairportseqid = null; } else {
      this.destairportseqid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destcitymarketid = null; } else {
      this.destcitymarketid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.destcityname = null; } else {
      this.destcityname = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.deststate = null; } else {
      this.deststate = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.deststatefips = null; } else {
      this.deststatefips = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.deststatename = null; } else {
      this.deststatename = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.destwac = null; } else {
      this.destwac = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.depdel15 = null; } else {
      this.depdel15 = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.departuredelaygroups = null; } else {
      this.departuredelaygroups = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.deptimeblk = null; } else {
      this.deptimeblk = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.taxiout = null; } else {
      this.taxiout = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wheelsoff = null; } else {
      this.wheelsoff = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.wheelson = null; } else {
      this.wheelson = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.taxiin = null; } else {
      this.taxiin = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.crsarrtime = null; } else {
      this.crsarrtime = java.sql.Time.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrdelay = null; } else {
      this.arrdelay = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrdel15 = null; } else {
      this.arrdel15 = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.arrivaldelaygroups = null; } else {
      this.arrivaldelaygroups = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.arrtimeblk = null; } else {
      this.arrtimeblk = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.distancegroup = null; } else {
      this.distancegroup = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.divairportlandings = null; } else {
      this.divairportlandings = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    flights o = (flights) super.clone();
    o.flightdate = (o.flightdate != null) ? (java.sql.Date) o.flightdate.clone() : null;
    o.crsdeptime = (o.crsdeptime != null) ? (java.sql.Time) o.crsdeptime.clone() : null;
    o.deptime = (o.deptime != null) ? (java.sql.Time) o.deptime.clone() : null;
    o.arrtime = (o.arrtime != null) ? (java.sql.Time) o.arrtime.clone() : null;
    o.wheelsoff = (o.wheelsoff != null) ? (java.sql.Time) o.wheelsoff.clone() : null;
    o.wheelson = (o.wheelson != null) ? (java.sql.Time) o.wheelson.clone() : null;
    o.crsarrtime = (o.crsarrtime != null) ? (java.sql.Time) o.crsarrtime.clone() : null;
    return o;
  }

  public void clone0(flights o) throws CloneNotSupportedException {
    o.flightdate = (o.flightdate != null) ? (java.sql.Date) o.flightdate.clone() : null;
    o.crsdeptime = (o.crsdeptime != null) ? (java.sql.Time) o.crsdeptime.clone() : null;
    o.deptime = (o.deptime != null) ? (java.sql.Time) o.deptime.clone() : null;
    o.arrtime = (o.arrtime != null) ? (java.sql.Time) o.arrtime.clone() : null;
    o.wheelsoff = (o.wheelsoff != null) ? (java.sql.Time) o.wheelsoff.clone() : null;
    o.wheelson = (o.wheelson != null) ? (java.sql.Time) o.wheelson.clone() : null;
    o.crsarrtime = (o.crsarrtime != null) ? (java.sql.Time) o.crsarrtime.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("flightdate", this.flightdate);
    __sqoop$field_map.put("airline", this.airline);
    __sqoop$field_map.put("origin", this.origin);
    __sqoop$field_map.put("dest", this.dest);
    __sqoop$field_map.put("cancelled", this.cancelled);
    __sqoop$field_map.put("diverted", this.diverted);
    __sqoop$field_map.put("crsdeptime", this.crsdeptime);
    __sqoop$field_map.put("deptime", this.deptime);
    __sqoop$field_map.put("depdelayminutes", this.depdelayminutes);
    __sqoop$field_map.put("depdelay", this.depdelay);
    __sqoop$field_map.put("arrtime", this.arrtime);
    __sqoop$field_map.put("arrdelayminutes", this.arrdelayminutes);
    __sqoop$field_map.put("airtime", this.airtime);
    __sqoop$field_map.put("crselapsedtime", this.crselapsedtime);
    __sqoop$field_map.put("actualelapsedtime", this.actualelapsedtime);
    __sqoop$field_map.put("distance", this.distance);
    __sqoop$field_map.put("year", this.year);
    __sqoop$field_map.put("quarter", this.quarter);
    __sqoop$field_map.put("month", this.month);
    __sqoop$field_map.put("dayofmonth", this.dayofmonth);
    __sqoop$field_map.put("dayofweek", this.dayofweek);
    __sqoop$field_map.put("marketing_airline_network", this.marketing_airline_network);
    __sqoop$field_map.put("operated_or_branded_code_share_partners", this.operated_or_branded_code_share_partners);
    __sqoop$field_map.put("dot_id_marketing_airline", this.dot_id_marketing_airline);
    __sqoop$field_map.put("iata_code_marketing_airline", this.iata_code_marketing_airline);
    __sqoop$field_map.put("flight_number_marketing_airline", this.flight_number_marketing_airline);
    __sqoop$field_map.put("operating_airline", this.operating_airline);
    __sqoop$field_map.put("dot_id_operating_airline", this.dot_id_operating_airline);
    __sqoop$field_map.put("iata_code_operating_airline", this.iata_code_operating_airline);
    __sqoop$field_map.put("tail_number", this.tail_number);
    __sqoop$field_map.put("flight_number_operating_airline", this.flight_number_operating_airline);
    __sqoop$field_map.put("originairportid", this.originairportid);
    __sqoop$field_map.put("originairportseqid", this.originairportseqid);
    __sqoop$field_map.put("origincitymarketid", this.origincitymarketid);
    __sqoop$field_map.put("origincityname", this.origincityname);
    __sqoop$field_map.put("originstate", this.originstate);
    __sqoop$field_map.put("originstatefips", this.originstatefips);
    __sqoop$field_map.put("originstatename", this.originstatename);
    __sqoop$field_map.put("originwac", this.originwac);
    __sqoop$field_map.put("destairportid", this.destairportid);
    __sqoop$field_map.put("destairportseqid", this.destairportseqid);
    __sqoop$field_map.put("destcitymarketid", this.destcitymarketid);
    __sqoop$field_map.put("destcityname", this.destcityname);
    __sqoop$field_map.put("deststate", this.deststate);
    __sqoop$field_map.put("deststatefips", this.deststatefips);
    __sqoop$field_map.put("deststatename", this.deststatename);
    __sqoop$field_map.put("destwac", this.destwac);
    __sqoop$field_map.put("depdel15", this.depdel15);
    __sqoop$field_map.put("departuredelaygroups", this.departuredelaygroups);
    __sqoop$field_map.put("deptimeblk", this.deptimeblk);
    __sqoop$field_map.put("taxiout", this.taxiout);
    __sqoop$field_map.put("wheelsoff", this.wheelsoff);
    __sqoop$field_map.put("wheelson", this.wheelson);
    __sqoop$field_map.put("taxiin", this.taxiin);
    __sqoop$field_map.put("crsarrtime", this.crsarrtime);
    __sqoop$field_map.put("arrdelay", this.arrdelay);
    __sqoop$field_map.put("arrdel15", this.arrdel15);
    __sqoop$field_map.put("arrivaldelaygroups", this.arrivaldelaygroups);
    __sqoop$field_map.put("arrtimeblk", this.arrtimeblk);
    __sqoop$field_map.put("distancegroup", this.distancegroup);
    __sqoop$field_map.put("divairportlandings", this.divairportlandings);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("flightdate", this.flightdate);
    __sqoop$field_map.put("airline", this.airline);
    __sqoop$field_map.put("origin", this.origin);
    __sqoop$field_map.put("dest", this.dest);
    __sqoop$field_map.put("cancelled", this.cancelled);
    __sqoop$field_map.put("diverted", this.diverted);
    __sqoop$field_map.put("crsdeptime", this.crsdeptime);
    __sqoop$field_map.put("deptime", this.deptime);
    __sqoop$field_map.put("depdelayminutes", this.depdelayminutes);
    __sqoop$field_map.put("depdelay", this.depdelay);
    __sqoop$field_map.put("arrtime", this.arrtime);
    __sqoop$field_map.put("arrdelayminutes", this.arrdelayminutes);
    __sqoop$field_map.put("airtime", this.airtime);
    __sqoop$field_map.put("crselapsedtime", this.crselapsedtime);
    __sqoop$field_map.put("actualelapsedtime", this.actualelapsedtime);
    __sqoop$field_map.put("distance", this.distance);
    __sqoop$field_map.put("year", this.year);
    __sqoop$field_map.put("quarter", this.quarter);
    __sqoop$field_map.put("month", this.month);
    __sqoop$field_map.put("dayofmonth", this.dayofmonth);
    __sqoop$field_map.put("dayofweek", this.dayofweek);
    __sqoop$field_map.put("marketing_airline_network", this.marketing_airline_network);
    __sqoop$field_map.put("operated_or_branded_code_share_partners", this.operated_or_branded_code_share_partners);
    __sqoop$field_map.put("dot_id_marketing_airline", this.dot_id_marketing_airline);
    __sqoop$field_map.put("iata_code_marketing_airline", this.iata_code_marketing_airline);
    __sqoop$field_map.put("flight_number_marketing_airline", this.flight_number_marketing_airline);
    __sqoop$field_map.put("operating_airline", this.operating_airline);
    __sqoop$field_map.put("dot_id_operating_airline", this.dot_id_operating_airline);
    __sqoop$field_map.put("iata_code_operating_airline", this.iata_code_operating_airline);
    __sqoop$field_map.put("tail_number", this.tail_number);
    __sqoop$field_map.put("flight_number_operating_airline", this.flight_number_operating_airline);
    __sqoop$field_map.put("originairportid", this.originairportid);
    __sqoop$field_map.put("originairportseqid", this.originairportseqid);
    __sqoop$field_map.put("origincitymarketid", this.origincitymarketid);
    __sqoop$field_map.put("origincityname", this.origincityname);
    __sqoop$field_map.put("originstate", this.originstate);
    __sqoop$field_map.put("originstatefips", this.originstatefips);
    __sqoop$field_map.put("originstatename", this.originstatename);
    __sqoop$field_map.put("originwac", this.originwac);
    __sqoop$field_map.put("destairportid", this.destairportid);
    __sqoop$field_map.put("destairportseqid", this.destairportseqid);
    __sqoop$field_map.put("destcitymarketid", this.destcitymarketid);
    __sqoop$field_map.put("destcityname", this.destcityname);
    __sqoop$field_map.put("deststate", this.deststate);
    __sqoop$field_map.put("deststatefips", this.deststatefips);
    __sqoop$field_map.put("deststatename", this.deststatename);
    __sqoop$field_map.put("destwac", this.destwac);
    __sqoop$field_map.put("depdel15", this.depdel15);
    __sqoop$field_map.put("departuredelaygroups", this.departuredelaygroups);
    __sqoop$field_map.put("deptimeblk", this.deptimeblk);
    __sqoop$field_map.put("taxiout", this.taxiout);
    __sqoop$field_map.put("wheelsoff", this.wheelsoff);
    __sqoop$field_map.put("wheelson", this.wheelson);
    __sqoop$field_map.put("taxiin", this.taxiin);
    __sqoop$field_map.put("crsarrtime", this.crsarrtime);
    __sqoop$field_map.put("arrdelay", this.arrdelay);
    __sqoop$field_map.put("arrdel15", this.arrdel15);
    __sqoop$field_map.put("arrivaldelaygroups", this.arrivaldelaygroups);
    __sqoop$field_map.put("arrtimeblk", this.arrtimeblk);
    __sqoop$field_map.put("distancegroup", this.distancegroup);
    __sqoop$field_map.put("divairportlandings", this.divairportlandings);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
