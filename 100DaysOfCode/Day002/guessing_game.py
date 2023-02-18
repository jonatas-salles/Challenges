from random import randint


def game(attempts):
    random_number = randint(1, 100)

    while attempts > 0:
        print(f"\nYou have {attempts} attempts remaining to guess the number.")
        try:
            guess = int(input("Make a guess: "))
        except:
            print("Invalid guess, only numbers are accepted\nTry again")
            exit()

        if guess == random_number:
            print(f"You got it! The answer was {random_number}.")
            exit()
        if attempts != 1:
            if guess < random_number:
                print("Too low.\nGuess again.")
            else:
                print("Too high.\nGuess again.")
        
        attempts -= 1
    
    print("You've run out of guesses, you lose.")
    exit()

def menu():
    print("Welcome to the Number Guessing Game!")
    print("I'm thinking of a number between 1 and 100.")

    print("Choose a difficulty. Type 'easy' or 'hard': ")
    difficulty = input("> ").lower()
    
    game(set_difficulty(difficulty))

def set_difficulty(difficulty):
    if difficulty == 'easy':
        return 10
    elif difficulty == 'hard':
        return 5
    else:
        print("Requested difficulty is invalid. Please try again...")
        exit()

menu()
    
