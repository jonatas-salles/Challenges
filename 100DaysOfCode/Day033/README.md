# CAR API WITH FLASK

To run and test this you will need to:

1. Create your own starting DATABASE in MySQL with the commands in /db/CreateDatabase.sql
2. Change the host, user and password at the connector.
3. Follow the data pattern for the POST and DELETE.

EXAMPLE OF POST
{
    "make": "Chevrolet",
    "model": "Omega",
    "year": 1995
}

EXAMPLE OF DELETE
{
    "id": 5
}