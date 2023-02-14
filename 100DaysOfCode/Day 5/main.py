import json
from urllib.request import urlopen

url = "https://ipinfo.io/json"

response = urlopen(url)

data = json.load(response)

ip = data['ip']
org = data['org']
city = data['city']
country = data['country']
region = data['region']

print(f'Detalhes do IP externo: ')
print(f'IP: {ip} | Country: {country} | City: {city} | Region: {region}')