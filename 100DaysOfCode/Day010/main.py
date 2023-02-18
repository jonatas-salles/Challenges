from turtle import Turtle, Screen
from random import randint, choice

turtle = Turtle()
turtle.shape("classic")

screen = Screen()
screen.bgcolor("grey")
screen.colormode(255)

def draw_shape(sides):
    angle = 360 / sides
    turtle.pencolor(randint(0, 255), randint(0, 255), randint(0, 255))

    for _ in range(sides):
        turtle.forward(100)
        turtle.right(angle)

# for i in range(3, 11):
#      draw_shape(i)

def random_walk(steps):
    directions = [0, 90, 180, 270]
    turtle.pensize(10)
    turtle.speed(5)

    while steps >= 0:
        turtle.pencolor(randint(0, 255), randint(0, 255), randint(0, 255))
        turtle.forward(25)

        turtle.setheading(choice(directions))
        
        steps -= 1

random_walk(200)

def draw_spirograph(gap):
    turtle.speed("fastest")

    for _ in range(int(360 / gap)):
        turtle.pencolor(randint(0, 255), randint(0, 255), randint(0, 255))
        turtle.circle(100)
        turtle.setheading(turtle.heading() + gap)

#draw_spirograph(5)

screen.exitonclick()
