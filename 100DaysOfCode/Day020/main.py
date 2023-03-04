import pandas

nato_df = pandas.read_csv(r"100DaysOfCode\Day020\nato_phonetic_alphabet.csv")

nato_dict = {row.letter:row.code for (index, row) in nato_df.iterrows()}

def generate_phonetic():
    word = input("Enter a word: ").upper()
    try:
        output = [nato_dict[letter] for letter in word]
    except KeyError:
        print("Sorry, only letters in the alphabet please.")
        generate_phonetic()
    else:
        print(output)

generate_phonetic()