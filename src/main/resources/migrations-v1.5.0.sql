--liquibase formatted sql

--changeset lionzz:migrations-v1.5.0 runOnChange:true splitStatements:false logicalFilePath:classpath:/liquibase/migrations-v1.5.0.sql
ALTER TABLE IF EXISTS forecasted_weather_data ADD COLUMN IF NOT EXISTS location_id uuid not null;
ALTER TABLE IF EXISTS weather ADD COLUMN IF NOT EXISTS location_id uuid not null;
