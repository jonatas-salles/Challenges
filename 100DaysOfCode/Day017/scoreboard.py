from turtle import Turtle
ALIGNMENT = "center"
FONT = ("Courier", 24, "normal")

class Scoreboard(Turtle):
    def __init__(self):
        super().__init__()
        self.score = 0
        self.color("white")
        self.penup()
        self.goto(0, 260)
        self.hideturtle()
        self.update_scoreboard()

    def update_scoreboard(self):
        self.clear()
        self.write(f"Score: {self.score} High Score: {self.get_high_score()}", align=ALIGNMENT, font=FONT)

    def reset(self):
        if self.score > self.get_high_score():
            self.set_high_score()
        self.score = 0
        self.update_scoreboard()
    
    def increase_score(self):
        self.score += 1
        self.update_scoreboard()

    def set_high_score(self):
        with open("Day017\data.txt", "w") as file:
            file.write(str(self.score))

    def get_high_score(self):
        with open("Day017\data.txt") as file:
            content = file.read()
            return int(content)