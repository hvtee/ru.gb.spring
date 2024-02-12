package com.example.services;

import com.example.models.Book;
import com.example.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        try {
            return bookRepository.findAll();
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("не найдено книг");
        }
    }

    public Book getBookById(long id) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            return book;
        } else {
            throw new NoSuchElementException("не найдена книга с id: " + id);
        }
    }

    public void deleteBookById(long id) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            bookRepository.delete(book);
        } else {
            throw new NoSuchElementException("не найдена книга с id: " + id);
        }
    }

    public Book createBook(String name) {
        Book book = new Book(name);
        return bookRepository.save(book);
    }


}
