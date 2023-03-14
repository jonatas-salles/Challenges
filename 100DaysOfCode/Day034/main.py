import mysql.connector
from flask import Flask, jsonify, make_response, request

app = Flask(__name__)
app.config['JSON_SORT_KEYS'] = False

connector = mysql.connector.connect(
    host='',
    user='',
    password='',
    database='Books'
)

@app.route('/books', methods=['GET'])
def get_books():
    cursor = connector.cursor()
    sql = "SELECT * FROM books"
    cursor.execute(sql)
    my_books = cursor.fetchall()

    books = list()
    for book in my_books:
        books.append(
            {
                'id': book[0],
                'title': book[1],
                'author': book[2]
            }
        )
    return make_response(
            jsonify(
                message="Books:",
                books=books
            )
        )

@app.route('/books/<int:id>', methods=['GET'])
def get_book_by_id(id):
    cursor = connector.cursor()
    sql = f"SELECT * FROM books WHERE id = {id}"
    cursor.execute(sql)
    my_book = cursor.fetchall()

    book = list()
    for item in my_book:
        book.append(
            {
                'id': item[0],
                'title': item[1],
                'author': item[2]
            }
        )
    return make_response(
            jsonify(
                message=f"{id}",
                book=book
            )
        ) if len(book) > 0 else jsonify(error="book id not found")

@app.route('/books', methods=['POST'])
def insert_book():
    book = request.json

    cursor = connector.cursor()
    sql = f'INSERT INTO books (title, author) VALUES ("{book["title"]}", "{book["author"]}")'
    cursor.execute(sql)
    connector.commit()

    return make_response(
            jsonify(
                message="Book registered successfully.",
                book=book
            )
        )

@app.route('/books', methods=['PUT'])
def edit_book():
    book = request.json

    cursor = connector.cursor()
    sql = f'UPDATE books SET title = "{book["title"]}", author = "{book["author"]}" WHERE id = {book["id"]}'
    cursor.execute(sql)
    connector.commit()

    return make_response(
            jsonify(
                message="Book edited successfully.",
                book=book
            )
        )

@app.route('/books', methods=['DELETE'])
def delete_book():
    book = request.json

    cursor = connector.cursor()
    sql = f'DELETE FROM books WHERE id = {book["id"]}'
    cursor.execute(sql)
    connector.commit()

    return make_response(
        jsonify(message="book deleted.")
    )

app.run()