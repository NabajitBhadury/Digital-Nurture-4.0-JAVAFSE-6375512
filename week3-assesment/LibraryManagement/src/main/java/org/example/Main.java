package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

/**
 * Main class to demonstrate Spring Framework configuration
 * and test the Library Management system
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.println("Loading Spring Application Context...");

        // Load Spring context from XML configuration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        try {
            // Get BookService bean from Spring container
            BookService bookService = (BookService) context.getBean("bookService");

            System.out.println("Spring context loaded successfully!");
            System.out.println("Testing Library Management Operations:\n");

            // Test the functionality
            testLibraryOperations(bookService);

            System.out.println("\n=== Spring Configuration Test Completed ===");
        } finally {
            // Close the context to release resources
            context.close();
        }
    }

    /**
     * Test various library operations
     * 
     * @param bookService The injected BookService instance
     */
    private static void testLibraryOperations(BookService bookService) {
        // Display initial library stats
        bookService.getLibraryStats();
        System.out.println();

        // Display all books
        bookService.displayAllBooks();
        System.out.println();

        // Search for existing book
        bookService.searchBook("1984");
        System.out.println();

        // Search for non-existing book
        bookService.searchBook("Harry Potter");
        System.out.println();

        // Add a new book
        bookService.addNewBook("The Catcher in the Rye");
        System.out.println();

        // Try to add duplicate book
        bookService.addNewBook("1984");
        System.out.println();

        // Display updated stats
        bookService.getLibraryStats();
        System.out.println();

        // Display all books again to see the changes
        bookService.displayAllBooks();
    }
}