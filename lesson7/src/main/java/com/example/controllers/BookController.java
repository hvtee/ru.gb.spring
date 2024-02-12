package com.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.models.Book;
import com.example.services.BookService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/books")
@Slf4j
@Tag(name = "Book controller")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    @Operation(summary = "Get all books", description = "Get all books from rep")
    public String getAllBooks(Model model) {
        log.info("Attempt to get all books");

        List<Book> books = null;
        try {
            books = bookService.getBooks();
        } catch (NoSuchElementException exception) {
            return "/error?code=404";
        }
        model.addAttribute("bookList", books);
        log.info("page /books returned");
        return "books/books";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id", description = "Get book by id")
    public String getBookById(
            @Parameter(description = "To transfer data") Model model,
            @Parameter(description = "The ID of the book") @PathVariable long id) {
        log.info("Attempt to get book by id");

        Book book = null;
        try {
            book = bookService.getBookById(id);
        } catch (NoSuchElementException e) {
            log.info("page /error returned");
            return "/error?code=404";
        }
        model.addAttribute("book", bookService.getBookById(id));
        log.info("page /book/{id} returned");
        return "books/book";
    }

    @PostMapping("")
    @Operation(summary = "Create book using name", description = "Create a new book with the provided name")
    public ResponseEntity<Book> postBook(
            @RequestBody(description = "Name of the book", required = true,
                    content = @Content(schema = @Schema(implementation = String.class))) @RequestParam String name) {
        log.info("Attempt to create book");

        Book book = bookService.createBook(name);
        log.info("Book created");
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by Id", description = "Delete a book by its unique identifier")
    public ResponseEntity<Void> deleteBookById(@Parameter(description = "The ID of the book") @PathVariable long id) {
        log.info("Attempt to delete book by id");

        try {
            bookService.deleteBookById(id);
        } catch (NoSuchElementException e) {
            log.info("page /error returned");
            return ResponseEntity.notFound().build();
        }
        log.info("Book deleted");
        return ResponseEntity.ok().build();
    }
}
