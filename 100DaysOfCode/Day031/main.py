import requests
from datetime import datetime

GENDER = "YOUR GENDER"
WEIGHT_KG = "YOUR WEIGHT"
HEIGHT_CM = "YOUR HEIGHT"
AGE = "YOUR AGE"

# Nutritionix APP ID and API Key.
APP_ID = ""
API_KEY = ""

exercise_endpoint = "https://trackapi.nutritionix.com/v2/natural/exercise"
exercise_text = input("Tell me the exercises you did: ")


headers = {
    "x-app-id": APP_ID,
    "x-app-key": API_KEY,
}

parameters = {
    "query": exercise_text,
    "gender": GENDER,
    "weight_kg": WEIGHT_KG,
    "height_cm": HEIGHT_CM,
    "age": AGE
}

response = requests.post(exercise_endpoint, json=parameters, headers=headers)
result = response.json()
print(f"Nutritionix API call: \n{result}\n")

today_date = datetime.now().strftime("%d/%m/%Y")
now_time = datetime.now().strftime("%X")

GOOGLE_SHEET_NAME = "YOUR GOOGLE SHEET NAME"
sheet_endpoint = "YOUR SHEETY ENDPOINT"

for exercise in result["exercises"]:
    sheet_inputs = {
        GOOGLE_SHEET_NAME: {
            "date": today_date,
            "time": now_time,
            "exercise": exercise["name"].title(),
            "duration": exercise["duration_min"],
            "calories": exercise["nf_calories"]
        }
    }

    sheet_response = requests.post(sheet_endpoint, json=sheet_inputs)

    print(f"Sheety Response: \n {sheet_response.text}")
