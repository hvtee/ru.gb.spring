package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreaders")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    // Пустой конструктор для JPA
    public Reader() {
    }
}
