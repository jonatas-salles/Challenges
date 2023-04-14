CREATE DATABASE carrospessoa;
USE carrospessoa;

CREATE TABLE pessoa(
    id int(11) NOT NULL AUTO_INCREMENT,
    login varchar(255) NOT NULL UNIQUE,
    senha varchar(255) NOT NULL,
    nome varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE carros(
    id int(11) NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    marca varchar(255) NOT NULL,
    ano int(11) NOT NULL,
    idPessoa int(11) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(idPessoa) REFERENCES pessoa(id)
);