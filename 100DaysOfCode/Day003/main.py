''' note: coffe_maker.py, menu.py and money_machine.py are provided by the theacher of the course.
1. Print report.
2. Check resources sufficient?
3. Process coins.
4. Check transaction successful?
5. Make coffee.
'''

from menu import Menu
from coffee_maker import CoffeeMaker
from money_machine import MoneyMachine

menu = Menu()
coffe_maker = CoffeeMaker()
money_machine = MoneyMachine()

while True:
    order = input(f"What would you like? ({menu.get_items()}): ").lower()

    if order == 'off':
        exit()
    
    elif order == 'report':
        coffe_maker.report()
        money_machine.report()

    else:
        drink = menu.find_drink(order)
        if coffe_maker.is_resource_sufficient(drink) and money_machine.make_payment(drink.cost):
                coffe_maker.make_coffee(drink)
