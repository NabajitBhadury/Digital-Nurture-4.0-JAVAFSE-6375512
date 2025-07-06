package com.library.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing Book data operations
 */
public class BookRepository {

    private List<String> books;

    public BookRepository() {
        this.books = new ArrayList<>();
        // Initialize with some sample books
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984");
        books.add("Pride and Prejudice");
    }

    /**
     * Get all books from the repository
     * 
     * @return List of book titles
     */
    public List<String> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Add a new book to the repository
     * 
     * @param bookTitle The title of the book to add
     */
    public void addBook(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Book added: " + bookTitle);
    }

    /**
     * Find a book by title
     * 
     * @param title The title to search for
     * @return true if book exists, false otherwise
     */
    public boolean findBookByTitle(String title) {
        return books.contains(title);
    }

    /**
     * Get the total number of books
     * 
     * @return The count of books
     */
    public int getTotalBooks() {
        return books.size();
    }
}
