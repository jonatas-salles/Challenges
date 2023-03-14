# BOOK CRUD API WITH FLASK

To run and test this you will need to:

1. Create your own starting DATABASE in MySQL with the commands in /db/CreateDatabase.sql
2. Change the host, user and password at the connector.
3. Follow the data pattern/path for the GET_BY_ID, POST, PUT and DELETE.

EXAMPLE OF GET_BY_ID
http://localhost/books/4

EXAMPLE OF POST
{
    "title": "Harry Potter - The Philopher's Stone",
    "author": "J.K. Rowling"
}

EXAMPLE OF PUT
{
    "id": 3,
    "title": "Harry Potter - The Philopher's Stone",
    "author": "J.K. Rowling"
}

EXAMPLE OF DELETE
{
    "id": 3
}