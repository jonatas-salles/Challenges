import requests
import spotipy
from spotipy.oauth2 import SpotifyOAuth
from bs4 import BeautifulSoup

sp = spotipy.Spotify(
    auth_manager=SpotifyOAuth(
        scope="playlist-modify-private",
        redirect_uri="http://localhost:8888/callback",
        client_id="",
        client_secret="",
        show_dialog=True,
        cache_path="token.txt"
    )
)
user_id = sp.current_user()["id"]

url = "https://www.billboard.com/charts/hot-100/"
travel_time = input("Which year do you want to travel to? Type the date in this format YYYY-MM-DD ")

response = requests.get(url+travel_time)
web_html = response.text
soup = BeautifulSoup(web_html, "html.parser")

titles = soup.select("li ul li h3")
song_names = [title.getText().strip() for title in titles]

song_uris = []
year = travel_time.split("-")[0]
for song in song_names:
    result = sp.search(q=f"track:{song} year:{year}", type="track")
    print(result)
    try:
        uri = result["tracks"]["items"][0]["uri"]
        song_uris.append(uri)
    except:
        print(f"{song} doesn't exist in Spotify. Skipped.")

playlist = sp.user_playlist_create(user=user_id, name=f"{travel_time} Billboard 100", public=False)

sp.playlist_add_items(playlist_id=playlist["id"], items=song_uris)
