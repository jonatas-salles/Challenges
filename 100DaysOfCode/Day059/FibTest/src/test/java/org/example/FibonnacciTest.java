package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonnacciTest {
    @Test
    void shouldReturnZero() {
        var sequence = new Fibonnacci();
        assertEquals(0, sequence.get_fibonnacci_position(0));
    }

    @Test
    void shouldReturnOne() {
        var sequence = new Fibonnacci();
        assertEquals(1, sequence.get_fibonnacci_position(3));
    }

    @Test
    void shouldReturnTwohundredthirtythree() {
        var sequence = new Fibonnacci();
        assertEquals(233, sequence.get_fibonnacci_position(14));
    }

    @Test
    void negativePositionShouldReturnIllegalArgumentException() {
        var sequence = new Fibonnacci();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    sequence.get_fibonnacci_position(-1);
                });
    }
}