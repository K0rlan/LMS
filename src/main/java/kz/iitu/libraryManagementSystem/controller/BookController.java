package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping("")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setBook_id(id);
        bookService.updateBook(book);
    }

    @GetMapping("/find/")
    public List<Book> search(@RequestParam String text){
        return bookService.searchBooks(text);
    }

    @GetMapping("/{id}")
    public Optional<Book> getUserById(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }
}
