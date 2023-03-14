USE Books;

CREATE TABLE books (
    id integer not null auto_increment,
    title varchar(100),
    author varchar(100),
    PRIMARY KEY (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_resuilts = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO books (title, author) VALUES ('Harry Potter - Chamber of Secrets', 'J.K. Rowling');
INSERT INTO books (title, author) VALUES ('Lord Of Rings - The Ring Sets Out', 'J.R.R. Tolkien');