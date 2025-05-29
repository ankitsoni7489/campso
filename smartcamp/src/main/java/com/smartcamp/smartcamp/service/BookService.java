package com.smartcamp.smartcamp.service;



import com.smartcamp.smartcamp.model.Book;
import com.smartcamp.smartcamp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepository;

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Delete by ID
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    // Delete by title
    public String deleteBookByTitle(String title) {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookRepository.delete(book);
                return "Book with title '" + title + "' deleted successfully.";
            }
        }
        return "Book with title '" + title + "' not found.";
    }
}
