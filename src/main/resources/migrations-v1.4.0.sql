--liquibase formatted sql

--changeset lionzz:migrations-v1.4.0 runOnChange:true splitStatements:false logicalFilePath:classpath:/liquibase/migrations-v1.4.0.sql
CREATE TABLE IF NOT EXISTS user_table
(
    id       UUID NOT NULL default gen_random_uuid(),
    username text NOT NULL,
    password text NOT NULL,
    location uuid,
    CONSTRAINT "PK_eryaf1acdb753f98bb31f5b7977" PRIMARY KEY ("id")
);


INSERT INTO user_table (username, password) VALUES ('lionzz', '$2a$10$ijGwFC1GUMNxX9lWLz2au.y03jijFO4WHSG3/OCyMXKxbr9d6T3Iy')
