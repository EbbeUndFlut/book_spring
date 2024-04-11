package dev.opafritz.book.service;

import dev.opafritz.book.model.Book;
import dev.opafritz.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public ResponseEntity<Iterable<Book>> getAllBooks(){
        return ResponseEntity.ok().body(bookRepository.findAll());
    }

    public ResponseEntity<Book> createBook(Book book){
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    public ResponseEntity<Void> deleteBook(Integer id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Book> updateBook(Integer id, Book book){
        if (bookRepository.existsById(id)){
            book.setId(id);
            Book savedBook = bookRepository.save(book);
            return ResponseEntity.ok(savedBook);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
 }
