package com.example.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "readers")
@Schema(name = "Model for readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
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
