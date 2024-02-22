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
        // Arrange
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());
        when(bookService.getBooks()).thenReturn(mockBooks);

        // Act
        String viewName = bookController.getAllBooks(model);

        // Assert
        assertEquals("books/books", viewName);
        verify(model).addAttribute("bookList", mockBooks);
    }

    @Test
    public void testGetBookById() {
        // Arrange
        long bookId = 1L;
        Book mockBook = new Book();
        when(bookService.getBookById(bookId)).thenReturn(mockBook);

        // Act
        String viewName = bookController.getBookById(model, bookId);

        // Assert
        assertEquals("books/book", viewName);
        verify(model).addAttribute("book", mockBook);
    }

    @Test
    public void testPostBook() {
        // Arrange
        String bookName = "Test Book";
        Book mockBook = new Book();
        mockBook.setName(bookName);
        when(bookService.createBook(bookName)).thenReturn(mockBook);

        // Act
        ResponseEntity<Book> responseEntity = bookController.postBook(bookName);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockBook, responseEntity.getBody());
    }


    @Test
    public void testDeleteBookById() {
        // Arrange
        long bookId = 1L;

        // Act
        ResponseEntity<Void> responseEntity = bookController.deleteBookById(bookId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(bookService).deleteBookById(bookId);
    }
}
