USE Songs;

CREATE TABLE songs (
    id integer not null auto_increment,
    name varchar(100),
    composer varchar(100),
    release_year int,
    PRIMARY KEY (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_resuilts = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO songs (name, composer, release_year) VALUES ('Controllah', 'Gorillaz - Ft. MC Bin Laden', 2023);
INSERT INTO songs (name, composer, release_year) VALUES ('Beatiful', 'Eminem', 2009);
