package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById(long id) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            return book;
        } else {
            throw new NoSuchElementException("не найдена книга с id: " + id);
        }
    }

    public Book delBookById(long id) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            return book;
        } else {
            throw new NoSuchElementException("не найдена книга с id: " + id);
        }
    }

    public Book createBook(String name) {
        Book book = new Book(name);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
