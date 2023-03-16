import mysql.connector
from flask import Flask, request, make_response, jsonify

app = Flask(__name__)
app.config['JSON_SORT_KEYS'] = False

connector = mysql.connector.connect(
    host='',
    user='',
    password='',
    database='Songs'
)

def reindex():
    cursor = connector.cursor()

    cursor.execute("SET @count := 0")
    sql = "UPDATE songs SET id = @count:= @count+1"
    cursor.execute(sql)
    connector.commit()

@app.route('/songs', methods=['GET'])
def get_songs():
    cursor = connector.cursor()
    sql = "SELECT * FROM songs"
    cursor.execute(sql)
    my_songs = cursor.fetchall()

    songs = list()
    for song in my_songs:
        songs.append(
            {
                'id': song[0],
                'name': song[1],
                'composer': song[2],
                'release_year': song[3]
            }
        )
    return make_response(
        jsonify(
            message="List of songs:",
            songs=songs
            )
        )

@app.route('/songs', methods=['POST'])
def add_song():
    song = request.json

    cursor = connector.cursor()
    sql = f'INSERT INTO songs (name, composer, release_year) VALUES ("{song["name"]}", "{song["composer"]}", {song["release_year"]})'
    cursor.execute(sql)
    connector.commit()
    reindex()

    return make_response(
        jsonify(
            message="Song added",
            song=song
            )
        )

@app.route('/songs', methods=['PUT'])
def update_song():
    song = request.json

    cursor = connector.cursor()
    sql = f'UPDATE songs SET name = "{song["name"]}", composer = "{song["composer"]}", release_year = {song["release_year"]} WHERE id = {song["id"]}'
    cursor.execute(sql)
    connector.commit()

    return make_response(
        jsonify(
            message="Song updated",
            song=song
        )
    )

@app.route('/songs', methods=['DELETE'])
def delete_song():
    song = request.json

    cursor = connector.cursor()
    sql = f'DELETE FROM songs where id = {song["id"]}'
    cursor.execute(sql)
    connector.commit()
    reindex()

    return make_response(
        jsonify(
            message="Song deleted",
            song=song
        )
    )

app.run()
