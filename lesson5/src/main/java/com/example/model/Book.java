package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
}

