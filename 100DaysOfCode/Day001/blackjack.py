from random import choice
import os

## BLACKJACK GAME

## Use the following list as the deck of cards:
## cards = [11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10]
## The cards in the list have equal probability of being drawn.
## Cards are not removed from the deck as they are drawn.
## The computer is the dealer.
## Dealer stands at 17.

cards = [11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10]

def menu():
    print("Want to start a new game? y/n")

def score(current_cards):
    score = 0
    score = (sum(card for card in current_cards))

    return score

def newCard():
    return int(choice(cards))

def showHands(player_cards, dealer_cards):
    print(f'Final hand: {player_cards}, final score {score(player_cards)}')
    print(f"Dealer's final hand {dealer_cards}, final score {score(dealer_cards)}")

def endGame(player_cards, dealer_cards, bust = False, bj = False):
    print("")
    player_score = score(player_cards)
    dealer_score = score(dealer_cards)

    while dealer_score < 17:
        dealer_cards.append(newCard())
        dealer_score = score(dealer_cards)

    if bj == True:
        showHands(player_cards, dealer_cards)
        print("BLACKJACK 🃏 You won! 😎")
    
    elif bust == True:
        showHands(player_cards, dealer_cards)
        print("You bust! 💣")
    
    else:        
        if player_score > dealer_score or dealer_score > 21:
            showHands(player_cards, dealer_cards)
            print("You won! 😎")
    
        elif player_score == dealer_score:
            showHands(player_cards, dealer_cards)
            print("Draw! 😢")
    
        else:
            showHands(player_cards, dealer_cards)
            print("You lose! 🤬")
    
    print("Do you want to play a new game? y/n:") 
    play_again = input("> ").lower()

    while True:
        if play_again == 'y':
            os.system('cls')
            game()
            break
        elif play_again == 'n':
            exit()
        
def game():
    player_cards = [choice(cards), choice(cards)]
    dealer_cards = [choice(cards), choice(cards)]
    print("\nWelcome to the blackjack table")

    while True:
        print(f'Your cards: {player_cards} Current score: {score(player_cards)}')
        print(f"Dealer's first card: {dealer_cards[0]}\n")
        if score(player_cards) == 21:
                endGame(player_cards, dealer_cards, bj=True)
                break
        print("Type 'y' to get another card, type 'n' to pass")
        answer = input("> ").lower()

        if(answer == 'y'):
            player_cards.append(newCard())
            if score(player_cards) >= 21:
                endGame(player_cards, dealer_cards, bust=True)
                break
        elif(answer == 'n'):
            endGame(player_cards, dealer_cards)
            break

while True:
    menu()
    answer = input("> ").lower()
    if answer == 'y':
        game()
    elif answer == 'n':
        break
    else:
        menu()