import requests
from datetime import datetime

TOKEN = ""
USERNAME = ""
GRAPH_ID = "graph1"
pixela_endpoint = "https://pixe.la/v1/users"

user_params = {
    "token": TOKEN,
    "username": USERNAME,
    "agreeTermsOfService": "yes",
    "notMinor": "yes"
}

# COMMENT THIS TWO LINES AFTER SUCCEDING
response = requests.post(url=pixela_endpoint, json=user_params)
print(response.json())

graph_endpoint = f"{pixela_endpoint}/{USERNAME}/graphs"

graph_config = {
    "id": GRAPH_ID,
    "name": "Study Frequency Graph",
    "unit": "commit",
    "type": "int",
    "color": "kuro"
}

headers = {
    "X-USER-TOKEN": TOKEN
}

# COMMENT THIS TWO LINES AFTER SUCCEDING
response = requests.post(url=graph_endpoint, json=graph_config, headers=headers)
print(response.text)

pixel_creation_endpoint = f"{pixela_endpoint}/{USERNAME}/graphs/{GRAPH_ID}"

today = datetime.now()

pixel_data = {
    "date": today.strftime("%Y%m%d"),
    "quantity": input("How many commits you made today? ")
}

response = requests.post(url=pixel_creation_endpoint, json=pixel_data, headers=headers)
print(response.text)