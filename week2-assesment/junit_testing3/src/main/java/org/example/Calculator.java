package org.example;

public class Calculator {
    private double memory;

    public Calculator() {
        this.memory = 0;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public void storeInMemory(double value) {
        this.memory = value;
    }

    public double recallMemory() {
        return this.memory;
    }

    public void clearMemory() {
        this.memory = 0;
    }
} 