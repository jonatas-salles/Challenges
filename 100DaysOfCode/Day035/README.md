# LIST OF SONGS API WITH FLASK

To run and test this you will need to:

1. Create your own starting DATABASE in MySQL with the commands in /db/CreateDatabase.sql
2. Change the host, user and password at the connector.
3. Follow the data pattern for the POST, PUT and DELETE.

EXAMPLE OF POST
{
    "name": "Mockingbirdd",
    "composer": "Eminem",
    "release_year": 2004
}

EXAMPLE OF PUT
{
    "id": 3,
    "name": "Mockingbird",
    "composer": "Eminem",
    "release_year": 2004
}

EXAMPLE OF DELETE
{
    "id": 3
}