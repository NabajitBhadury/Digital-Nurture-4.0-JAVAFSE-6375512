package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    private Main calculator;

    @Before
    public void setUp() {
        calculator = new Main();
    }

    @Test
    public void testAddition() {
        assertEquals(4, calculator.add(2, 2));
        assertEquals(-2, calculator.add(-1, -1));
        assertEquals(5, calculator.add(5, 0));
    }

    @Test
    public void testSubtraction() {
        assertEquals(3, calculator.subtract(5, 2));
        assertEquals(-1, calculator.subtract(2, 3));
        assertEquals(5, calculator.subtract(5, 0));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-6, calculator.multiply(2, -3));
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.divide(4, 2), 0.0001);
        assertEquals(0.5, calculator.divide(1, 2), 0.0001);
        assertEquals(-2.0, calculator.divide(4, -2), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(5, 0);
    }
} 