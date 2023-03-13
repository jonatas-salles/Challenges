USE Cars;

CREATE TABLE cars (
    id integer not null auto_increment,
    make varchar(100),
    model varchar(100),
    year integer,
    PRIMARY KEY (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_resuilts = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO cars (make, model, year) VALUES ('Fiat', 'Marea', 1999);
INSERT INTO cars (make, model, year) VALUES ('Fiat', 'Uno', 1992);
INSERT INTO cars (make, model, year) VALUES ('Ford', 'Escort', 1985);
INSERT INTO cars (make, model, year) VALUES ('Chevrolet', 'Chevette', 1978);
INSERT INTO cars (make, model, year) VALUES ('Volkswagen', 'Fusca', 1962);