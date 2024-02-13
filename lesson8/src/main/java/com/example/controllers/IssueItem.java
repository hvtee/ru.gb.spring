package com.example.controllers;

import lombok.Data;
import com.example.models.Book;
import com.example.models.Reader;

import java.time.LocalDateTime;

@Data
public class IssueItem {
    private Book bookName;
    private Reader readerName;
    private LocalDateTime timestamp;

    public IssueItem(Book bookName, Reader readerName, LocalDateTime timestamp) {
        this.bookName = bookName;
        this.readerName = readerName;
        this.timestamp = timestamp;
    }
}
