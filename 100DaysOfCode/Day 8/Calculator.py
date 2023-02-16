from time import sleep
import os

class Calculator():
    def __init__(self):
        self.display_value = 0
        self.operator = ""

    def display(self):
        print("-"*20)
        print(f"{self.display_value:>18}")
        print("-"*20)
    
    def get_operation(self):
        try:
            self.first_value = int(input("First value: "))
            self.second_value = int(input("Second value: "))
            self.operator = input("Select what to do (sum/subract/multiply/divide): ").lower()
        except:
            print("Error! Exiting...")
            sleep(1)
            exit()
    
    def calc(self):
        if self.operator == "sum":
            self.sum()
        elif self.operator == "subtract":
            self.subtract()
        elif self.operator == "multiply":
            self.multiply()
        elif self.operator == "divide":
            self.divide()
        else:
            print("Invalid operation, exiting...")
            sleep(1)
            exit()

        os.system('cls')
        self.display()
        self.ask_exit()
    
    def ask_exit(self):
        answer = input("Want to exit the application? yes or no: ").lower()

        if answer == "yes":
            exit()

    def sum(self):
        self.display_value = self.first_value + self.second_value

    def subtract(self):
        self.display_value = self.first_value - self.second_value

    def multiply(self):
        self.display_value = self.first_value * self.second_value

    def divide(self):
        self.display_value = self.first_value / self.second_value
