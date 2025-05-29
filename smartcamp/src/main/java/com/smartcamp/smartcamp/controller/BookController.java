package com.smartcamp.smartcamp.controller;



import com.smartcamp.smartcamp.model.Book;
import com.smartcamp.smartcamp.service.BookService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    // ✅ Show all books to students/admins
    @GetMapping("")
    public String viewLibrary(Model model, HttpSession session) {
        List<Book> books = bookService.getAllBooks();
        String choice = (String) session.getAttribute("choice");
        model.addAttribute("choice", choice);
        model.addAttribute("books", books);
        System.out.println(books);
        return "library"; // returns library.html
    }

    // ✅ Show add book form (admin only)
    @GetMapping("/admin/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book"; // returns add-book.html
    }

    // ✅ Handle form submission to add a book (admin only)
    @PostMapping("/admin/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/library";
    }

    // ✅ Delete a book by title (admin only)
    @PostMapping("/admin/delete/{title}")
    public String deleteBookByTitle(@PathVariable String title) {
        bookService.deleteBookByTitle(title);
        return "redirect:/library";
    }
}
