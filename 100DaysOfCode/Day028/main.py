import requests
import smtplib

MY_EMAIL = ""
MY_PASSWORD = ""
MY_LAT = 40.712776
MY_LONG = -74.005974

OWM_Endpoint = "https://api.openweathermap.org/data/2.5/onecall"
api_key = ""

parameters = {
    "lat": MY_LAT,
    "lon": MY_LONG,
    "appid": api_key,
    "exclude": "current,minutely,daily"
}

will_rain = False

response = requests.get(OWM_Endpoint, params=parameters)
response.raise_for_status()
weather_data = response.json()
weather_slice = weather_data["hourly"][:12]
for hour_data in weather_slice:
    condition_code = hour_data["weather"][0]["id"]
    if int(condition_code) < 600:
        will_rain = True

if will_rain:
    connection = smtplib.SMTP("smtp.gmail.com")
    connection.starttls()
    connection.login(MY_EMAIL, MY_PASSWORD)
    connection.sendmail(
    from_addr=MY_EMAIL,
    to_addrs=MY_EMAIL,
    msg="Subject:It will rain\n\nBring an umbrella."
    )
