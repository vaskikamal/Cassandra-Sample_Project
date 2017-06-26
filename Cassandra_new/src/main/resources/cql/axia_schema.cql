create keyspace if not exists axiaglobal WITH replication = {'class': 'SimpleStrategy', 'replication_factor':1};

CREATE TABLE Customer_BU_Details 
(
 bu_ID int,
 customerId int,
 bu_NAME text,
 totalNoEnergyMeters int,
 totalGasmeters int,
 totalsWatermeters int,
 bu_LocationIds set<int>,
 PRIMARY KEY(bu_ID, customerId)
 );
 
CREATE TABLE SmartMeter_Entries 
(
 meterID int,
 date text,
 reading bigint,
 timeStamp text,
 PRIMARY KEY(meterID, timeStamp)
 )WITH CLUSTERING ORDER BY (timeStamp DESC);
 
 create INDEX ON smartmeter_entries(date);
 create INDEX ON smartmeter_entries(timeStamp);