package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

/**
 * Service class for business logic related to Book operations
 */
public class BookService {

    private BookRepository bookRepository;

    // Default constructor
    public BookService() {
    }

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Get all available books
     * 
     * @return List of all books
     */
    public List<String> getAllBooks() {
        System.out.println("BookService: Fetching all books...");
        return bookRepository.getAllBooks();
    }

    /**
     * Add a new book to the library
     * 
     * @param bookTitle The title of the book to add
     */
    public void addNewBook(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.out.println("BookService: Invalid book title provided");
            return;
        }

        if (bookRepository.findBookByTitle(bookTitle)) {
            System.out.println("BookService: Book '" + bookTitle + "' already exists in the library");
        } else {
            bookRepository.addBook(bookTitle);
            System.out.println("BookService: Successfully added book '" + bookTitle + "'");
        }
    }

    /**
     * Search for a book by title
     * 
     * @param title The title to search for
     * @return true if book is found, false otherwise
     */
    public boolean searchBook(String title) {
        System.out.println("BookService: Searching for book '" + title + "'...");
        boolean found = bookRepository.findBookByTitle(title);
        if (found) {
            System.out.println("BookService: Book '" + title + "' found in the library");
        } else {
            System.out.println("BookService: Book '" + title + "' not found in the library");
        }
        return found;
    }

    /**
     * Get library statistics
     */
    public void getLibraryStats() {
        int totalBooks = bookRepository.getTotalBooks();
        System.out.println("BookService: Library Statistics - Total Books: " + totalBooks);
    }

    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        System.out.println("BookService: Displaying all books in the library:");
        List<String> books = getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }
}
