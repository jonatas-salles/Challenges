from Calculator import Calculator

app = Calculator()

app.display()

while True:
    app.get_operation()
    app.calc()
