import requests
import smtplib

MY_EMAIL = ""
MY_PASSWORD = ""
STOCK_API_KEY = ""
NEWS_API_KEY = ""
STOCK = "TSLA"
COMPANY_NAME = "Tesla Inc"

stock_parameters = {
    "function": "TIME_SERIES_DAILY_ADJUSTED",
    "symbol": STOCK,
    "apikey": STOCK_API_KEY
}

response = requests.get("https://www.alphavantage.co/query", params=stock_parameters)
data = response.json()["Time Series (Daily)"]
data_list = [value for (key, value) in data.items()]

yesterday_data = data_list[0]
yesterday_closing_price = yesterday_data["4. close"]

day_before_yesterday_data = data_list[1]
day_before_yesterday_closing_price = day_before_yesterday_data["4. close"]

difference = float(yesterday_closing_price) - float(day_before_yesterday_closing_price)
up_down = None
if difference > 0:
    up_down = "UP"
else:
    up_down = "DOWN"

diff_percent = round((difference / float(yesterday_closing_price)) * 100)

if abs(diff_percent) >= 5: 
    news_parameters = {
        "apiKey": NEWS_API_KEY,
        "qInTitle": COMPANY_NAME
    }
    
    news_response = requests.get("https://newsapi.org/v2/everything", news_parameters)
    articles = news_response.json()["articles"]
    three_articles = articles[:3]

    for i in range(0, 3):
        title = str(three_articles[i]["title"]).encode('utf-8')
        text = str(three_articles[i]["description"]).encode('utf-8')
        connection = smtplib.SMTP("smtp.gmail.com")
        connection.starttls()
        connection.login(MY_EMAIL, MY_PASSWORD)
        connection.sendmail(
        from_addr=MY_EMAIL,
        to_addrs=MY_EMAIL,
        msg=f"Subject:{STOCK}: {up_down} {diff_percent}% {title}\n\n{text}"
        )
