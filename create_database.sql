DROP SCHEMA IF EXISTS oblig3 CASCADE;

CREATE SCHEMA oblig3;
SET search_path TO oblig3;

-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;

CREATE TABLE ansatt
(
    ansattID serial,
    brukernavn varchar(4) not null,
    fornavn varchar(30) not null,
    etternavn varchar(30) not null,
    ansettelsedato DATE not null,
    stilling varchar(30) not null,
    maanedslonn integer not null,
    avdeling varchar not null,


    CONSTRAINT ansatt_pk PRIMARY KEY (ansattID)
);

create table avdeling
(
    avdeling serial,
    navn varchar(255) not null,
    sjef integer,

    constraint avdelingPK primary key (avdeling),
    constraint ansattFK foreign key (sjef)
            references ansatt(ansattID)
);

create table prosjekt
(
    prosjektID serial,
    navn varchar(255) not null,
    beskrivelse varchar(255) not null,
    ansatte integer not null,
    constraint prosjektPK primary key (prosjektID),
    constraint ansattFK foreign key (ansatte)
            references ansatt(ansattID)

);