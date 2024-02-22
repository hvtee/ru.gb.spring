package com.example.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "books")
@Schema(name = "Model for books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }
}

