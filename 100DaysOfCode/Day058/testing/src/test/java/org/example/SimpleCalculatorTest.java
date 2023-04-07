package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
    @Test
    void twoPlusTwoShouldEqualFour() {
        var calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void threePlusTwoShouldEqualFive() {
        var calculator = new SimpleCalculator();
        assertEquals(5, calculator.add(3, 2));
    }
}
