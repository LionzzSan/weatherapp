--liquibase formatted sql

--changeset lionzz:migrations-v1.1.0 runOnChange:true splitStatements:false logicalFilePath:classpath:/liquibase/migrations-v1.1.0.sql
CREATE TABLE IF NOT EXISTS weather
(
    id               UUID,
    temperature      NUMERIC                  DEFAULT 0,
    humidity         NUMERIC                  DEFAULT 0,
    wind_speed       NUMERIC                  DEFAULT 0,
    precipitation    NUMERIC                  DEFAULT 0,
    observation_time TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT "PK_b27af1acdb753f98bb3af5b7977" PRIMARY KEY ("id")
);
