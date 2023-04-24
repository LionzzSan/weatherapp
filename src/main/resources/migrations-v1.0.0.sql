--liquibase formatted sql

--changeset owner_name:migrations-v1.0.0 runOnChange:true splitStatements:false logicalFilePath:classpath:/liquibase/migrations-v1.0.0.sql
SELECT 1;
