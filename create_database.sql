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
    navn varchar(30),
    beskrivelse varchar(255),
    constraint prosjektPK primary key (prosjektID)
);

create table prosjektDeltagelse
(
    prosjektdeltagelseId serial,
    ansatt_id integer,
    prosjekt_id integer,
    timer integer,
    constraint prosjekDeltagelse_PK primary key (prosjektdeltagelseId),
    constraint ansattProsjekt_unik unique not null (ansatt_id, prosjekt_id),
    constraint ansatt_FK foreign key (ansatt_id) references ansatt(ansattID),
    constraint prosjekt_FK foreign key (prosjekt_id) references prosjekt(prosjektID)
);
INSERT INTO
    Prosjekt(navn, beskrivelse)
VALUES
    ('Trivselsprosjektet', 'Prosjekt angående trivelse til ansatte og flere'),
    ('Synergiprosjektet', 'Prosjekt om synergi i jobb miljøet'),
    ('Utviklingsprosjektet', 'Prosjekt angående utvikling av prossesser og verktøy');
