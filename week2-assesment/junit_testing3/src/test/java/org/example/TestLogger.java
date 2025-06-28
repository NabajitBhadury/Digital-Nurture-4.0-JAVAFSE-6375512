package org.example;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLogger implements TestRule {
    private final String logFile;
    private PrintWriter writer;

    public TestLogger(String filename) {
        this.logFile = filename;
        try {
            // Create directory if it doesn't exist
            Files.createDirectories(Paths.get("test-output"));
            // Append to file if it exists, create if it doesn't
            this.writer = new PrintWriter(new FileWriter("test-output/" + filename, true));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create log file", e);
        }
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    logMessage("Test Started: " + description.getMethodName() + " at " + timestamp);
                    base.evaluate();
                    logMessage("Test Passed: " + description.getMethodName());
                } catch (Throwable t) {
                    logMessage("Test Failed: " + description.getMethodName() + "\n" + t.getMessage());
                    throw t;
                } finally {
                    writer.flush();
                }
            }
        };
    }

    public void logMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
} 