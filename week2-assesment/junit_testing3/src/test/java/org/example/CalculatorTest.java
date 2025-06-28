package org.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;
    
    @Rule
    public TestLogger testLogger = new TestLogger("calculator-tests.log");

    @Before
    public void setUp() {
        calculator = new Calculator();
        testLogger.logMessage("Setting up test...");
    }

    @After
    public void tearDown() {
        calculator.clearMemory();
        testLogger.logMessage("Cleaning up test...");
    }

    @Test
    public void testAddition() {
        double a = 5.0;
        double b = 3.0;
        double expectedResult = 8.0;

        double actualResult = calculator.add(a, b);
        testLogger.logMessage(String.format("Testing addition: %f + %f = %f", a, b, actualResult));

        assertEquals("5.0 + 3.0 should equal 8.0", expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double a = 10.0;
        double b = 4.0;
        double expectedResult = 6.0;

        double actualResult = calculator.subtract(a, b);
        testLogger.logMessage(String.format("Testing subtraction: %f - %f = %f", a, b, actualResult));

        assertEquals("10.0 - 4.0 should equal 6.0", expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testMultiplication() {
        double a = 4.0;
        double b = 3.0;
        double expectedResult = 12.0;

        double actualResult = calculator.multiply(a, b);
        testLogger.logMessage(String.format("Testing multiplication: %f * %f = %f", a, b, actualResult));

        assertEquals("4.0 * 3.0 should equal 12.0", expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testDivision() {
        double a = 15.0;
        double b = 3.0;
        double expectedResult = 5.0;

        double actualResult = calculator.divide(a, b);
        testLogger.logMessage(String.format("Testing division: %f / %f = %f", a, b, actualResult));

        assertEquals("15.0 / 3.0 should equal 5.0", expectedResult, actualResult, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        double a = 10.0;
        double b = 0.0;
        testLogger.logMessage(String.format("Testing division by zero: %f / %f", a, b));
        calculator.divide(a, b);
    }

    @Test
    public void testMemoryOperations() {
        double valueToStore = 42.0;

        calculator.storeInMemory(valueToStore);
        double storedValue = calculator.recallMemory();
        testLogger.logMessage(String.format("Testing memory store: Stored %f, recalled %f", valueToStore, storedValue));
        assertEquals("Memory should store 42.0", valueToStore, storedValue, 0.0001);

        calculator.clearMemory();
        double clearedValue = calculator.recallMemory();
        testLogger.logMessage("Testing memory clear: Memory cleared");
        assertEquals("Memory should be 0 after clearing", 0.0, clearedValue, 0.0001);
    }
} 