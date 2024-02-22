package com.example;

import com.example.controllers.BookController;
import com.example.models.Book;
import com.example.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private Model model;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());
        when(bookService.getBooks()).thenReturn(mockBooks);

        String viewName = bookController.getAllBooks(model);

        assertEquals("books/books", viewName);
        verify(model).addAttribute("bookList", mockBooks);
    }

    @Test
    public void testGetBookById() {
        long bookId = 1L;
        Book mockBook = new Book();
        when(bookService.getBookById(bookId)).thenReturn(mockBook);

        String viewName = bookController.getBookById(model, bookId);

        assertEquals("books/book", viewName);
        verify(model).addAttribute("book", mockBook);
    }

    @Test
    public void testPostBook() {
        String bookName = "Test Book";
        Book mockBook = new Book();
        mockBook.setName(bookName);
        when(bookService.createBook(bookName)).thenReturn(mockBook);

        ResponseEntity<Book> responseEntity = bookController.postBook(bookName);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockBook, responseEntity.getBody());
    }


    @Test
    public void testDeleteBookById() {
        long bookId = 1L;

        ResponseEntity<Void> responseEntity = bookController.deleteBookById(bookId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(bookService).deleteBookById(bookId);
    }
}
