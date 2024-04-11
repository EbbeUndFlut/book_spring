package dev.opafritz.book.controller;

import dev.opafritz.book.model.Book;
import dev.opafritz.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public ResponseEntity<Iterable<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}
