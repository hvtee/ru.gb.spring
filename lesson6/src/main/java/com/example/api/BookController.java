package com.example.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.model.Book;
import com.example.service.BookService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book")
@Slf4j
@Tag(name = "Book controller")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/{id}")
    @Operation(summary = "Get book by Id")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        Book book = null;
        try {
            book = bookService.getBookById(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by Id")
    public ResponseEntity<Book> delById(@PathVariable long id) {
        Book book = null;
        try {
            book = bookService.delBookById(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping()
    @Operation(summary = "Create book using name")
    public ResponseEntity<Book> createBook(@RequestParam String name) {
        Book book = bookService.createBook(name);
        log.info("Book created");
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
}
