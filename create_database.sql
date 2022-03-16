DROP SCHEMA IF EXISTS Oblig3 CASCADE;

CREATE SCHEMA Oblig3;
SET search_path TO Oblig3;

-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;

CREATE TABLE ansatt
(
    brukernavn varchar(4) not null,
    fornavn varchar(30) not null,
    etternavn varchar(30) not null,
    ansettelsedato DATE not null,
    stilling varchar(30) not null,
    maanedslonn integer not null,

    CONSTRAINT ansatt_pk PRIMARY KEY (brukernavn)
);