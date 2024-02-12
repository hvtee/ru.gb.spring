package com.example.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbooks")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
}

