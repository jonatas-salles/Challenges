import mysql.connector
from flask import Flask, make_response, jsonify, request

connector = mysql.connector.connect(
    host='your_host',
    user='your_user',
    password='your_password',
    database='Cars'
)

app = Flask(__name__)
app.config['JSON_SORT_KEYS'] = False

@app.route('/cars', methods=['GET'])
def get_cars():
    cursor = connector.cursor()
    sql = "SELECT * FROM cars"
    cursor.execute(sql)
    my_cars = cursor.fetchall()

    cars = list()
    for car in my_cars:
        cars.append(
            {
                'id': car[0],
                'make': car[1],
                'model': car[2],
                'year': car[3]
            }
        )

    return make_response(
        jsonify(
            message="List of cars.",
            data=cars
        )
    )

@app.route('/cars', methods=['POST'])
def create_car():
    car = request.json
    
    cursor = connector.cursor()
    sql = f"INSERT INTO cars (make, model, year) VALUES ('{car['make']}', '{car['model']}', '{car['year']}')"
    cursor.execute(sql)
    connector.commit()

    return make_response(
        jsonify(
        message="car registered successfully.",
        car=car)
    )

@app.route('/cars', methods=['DELETE'])
def delete_car():
    car = request.json

    cursor = connector.cursor()
    sql = f"DELETE FROM cars WHERE id = {car['id']}"
    cursor.execute(sql)
    connector.commit()

    return make_response(
        jsonify(message="car removed.")
    )

app.run()
