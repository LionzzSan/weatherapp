--liquibase formatted sql

--changeset lionzz:migrations-v1.2.0 runOnChange:true splitStatements:false logicalFilePath:classpath:/liquibase/migrations-v1.2.0.sql
CREATE TABLE IF NOT EXISTS location
(
    id        UUID,
    name      NUMERIC DEFAULT 0,
    latitude  NUMERIC DEFAULT 0,
    longitude NUMERIC DEFAULT 0,
    CONSTRAINT "PK_ewfaf1acdb753f98bb3af5b7977" PRIMARY KEY ("id")
);

