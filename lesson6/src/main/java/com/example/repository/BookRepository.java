package com.example.repository;

import com.example.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    private final List<Book> books;
//
//    public BookRepository() {
//        this.books = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void generateData() {
//        books.addAll(List.of(
//                new Book("Book1"),
//                new Book("Book2"),
//                new Book("Book3")
//        ));
//    }
//
//    public Book getBookById(long id) {
//        return books.stream().filter(it -> Objects.equals(it.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public Book delBookById(long id) {
//        Book book = getBookById(id);
//        if (book != null) {
//            books.remove(book);
//        }
//        return book;
//    }
//
//    public Book createBook(String name) {
//        Book book = new Book(name);
//        books.add(book);
//        return book;
//    }
//
//    public List<Book> getAllBooks() {
//        return new ArrayList<>(books);
//    }
}