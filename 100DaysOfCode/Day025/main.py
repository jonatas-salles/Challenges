from datetime import datetime
import pandas
import smtplib

MY_EMAIL = ""
MY_PASSWORD = ""

today = datetime.now()
today = (today.month, today.day)

data = pandas.read_csv(r"100DaysOfCode\Day025\birthdays.csv")
birthdays = {(data_row["month"], data_row["day"]): data_row for (index, data_row) in data.iterrows()}
if today in birthdays:
    birthday_person = birthdays[today]
    file_path = r"100DaysOfCode\Day025\letter_template.txt"
    with open(file_path) as letter_file:
        contents = letter_file.read()
        contents = contents.replace("[NAME]", birthday_person["name"])

    with smtplib.SMTP("smtp.gmail.com") as connection:
        connection.starttls()
        connection.login(MY_EMAIL, MY_PASSWORD)
        connection.sendmail(from_addr=MY_EMAIL,
                            to_addrs=birthday_person["email"],
                            msg=f"Subject:Happy Birthday!\n\n{contents}"
                            )
