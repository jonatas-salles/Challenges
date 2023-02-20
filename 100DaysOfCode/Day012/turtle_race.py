from turtle import Turtle, Screen
import random

screen = Screen()
screen.setup(width=500, height=400)

is_race_on = False
turtles = []
colors = ["red", "orange", "yellow", "blue", "purple"]
user_bet = screen.textinput(title="Make your bet", prompt=f"Which turtle will win the race?\nred, orange, yellow, blue, purple\nEnter a color: ")

def create_turtles(colors):
    y_pos = -100
    for i in range(len(colors)):
        new_turtle = Turtle(shape="turtle")
        new_turtle.penup()
        new_turtle.color(colors[i])
        new_turtle.goto(x=-230, y=y_pos)
        y_pos += 50
        turtles.append(new_turtle)

create_turtles(colors)

if user_bet:
    is_race_on = True

while is_race_on:
    for turtle in turtles:
        rand_distance = random.randint(0, 10)
        turtle.forward(rand_distance)
        if turtle.xcor() > 230:
            is_race_on = False
            winner = turtle.pencolor()
            if winner == user_bet:
                print(f"You've won! The {winner} turtle is the winner!")
            else:
                print(f"You've lost! The {winner} turtle is the winner!")

screen.exitonclick()