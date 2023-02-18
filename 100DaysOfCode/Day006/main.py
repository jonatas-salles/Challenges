import pandas as pd

df = pd.DataFrame()
df = pd.read_csv(r'Day006\NetflixOriginals.csv', encoding_errors='ignore')
index = df.index

def getGenre(genero):
    global genero_list, score
    score = 0
    condition = df["Genre"] == genero
    genero_indices = index[condition]
    genero_list = genero_indices.to_list()

    for item in genero_list:
        print(df.loc[item])
        if df.loc[item, 'IMDB Score'] > score:
            score = df.loc[item, 'IMDB Score']
        print('-'*30)

getGenre("Comedy")
percent = (len(genero_list) * 100) / len(index)
print(f'O genero "Comedy" representa {percent:.0f}% do catalogo')
print(f'O maior score do IMDB desse genero é {score}')
