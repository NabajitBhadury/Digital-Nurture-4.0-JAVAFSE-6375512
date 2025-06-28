package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        
        String user = "John";
        int value = 42;
        logger.error("Error occurred for user: {} with value: {}", user, value);
        logger.warn("Warning: unusual activity detected for user: {}", user);
        
        try {
            throw new RuntimeException("Sample exception");
        } catch (Exception e) {
            logger.error("An exception occurred", e);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}