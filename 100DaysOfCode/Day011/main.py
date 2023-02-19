from turtle import Turtle, Screen
from random import randint

turtle = Turtle(shape="classic")
turtle.speed("fast")

screen = Screen()
screen.setworldcoordinates(-1, -1, 20, 20)
screen.colormode(255)

def random_color():
    turtle.pencolor(randint(0, 255), randint(0, 255), randint(0, 255))

def draw_hirst_painting():
    turtle.hideturtle()
    for _ in range(1, 11):
        random_color()
        random = randint(0, 10)
        if random == 0:
            pass
        else:
            turtle.dot(50)
        turtle.penup()
        turtle.forward(2)
        turtle.pendown()

    turtle.left(90)
    turtle.forward(2)
    turtle.left(90)
    turtle.penup()
    turtle.forward(20)
    turtle.left(180)
    turtle.pendown()

for _ in range(10):
    draw_hirst_painting()

screen.exitonclick()