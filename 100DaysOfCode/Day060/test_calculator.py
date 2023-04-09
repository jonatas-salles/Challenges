from calculator import Calculator
import pytest

def test_constructor():
    calculator = Calculator(2, 5)
    assert calculator.value_1 == 2
    assert calculator.value_2 == 5

def test_add():
    calc = Calculator(5, 2)
    assert calc.add() == 7

def test_subtract():
    calc = Calculator(2, 5)
    assert calc.subtract() == -3

def test_multiply():
    calc = Calculator(5, 2)
    assert calc.multiply() == 10

def test_divide():
    calc = Calculator(5, 2)
    assert calc.divide() == 2.5
    with pytest.raises(ZeroDivisionError):
        calc = Calculator(5, 0)
        calc.divide()