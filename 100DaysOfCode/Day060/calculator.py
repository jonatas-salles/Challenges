class Calculator:
    value_1: int
    value_2: int

    def __init__(self, value1, value2):
        self.value_1 = value1
        self.value_2 = value2

    def add(self):
        return self.value_1 + self.value_2
    
    def subtract(self):
        return self.value_1 - self.value_2
    
    def multiply(self):
        return self.value_1 * self.value_2
    
    def divide(self):
        if (self.value_2 == 0):
            raise ZeroDivisionError
        return self.value_1 / self.value_2
