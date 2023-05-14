--liquibase formatted sql

--changeset lionzz:migrations-v1.3.0 runOnChange:true splitStatements:false logicalFilePath:classpath:/liquibase/migrations-v1.3.0.sql
CREATE TABLE IF NOT EXISTS forecasted_weather_data
(
    id              UUID,
    high_temp       NUMERIC                  DEFAULT 0,
    low_temp        NUMERIC                  DEFAULT 0,
    precipitation   NUMERIC                  DEFAULT 0,
    forecasted_time TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT "PK_eryaf1acdb753f98bb3af5b7977" PRIMARY KEY ("id")
);
