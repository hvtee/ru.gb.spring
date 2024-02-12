package com.example.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "issues")
@Schema(name = "Model for issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Long id;
    @Column(name = "book_id", nullable = false)
    private Long bookId;
    @Column(name = "reader_id", nullable = false)
    private Long readerId;
    @Column(name = "time_stamp", nullable = false)
    private LocalDateTime timestamp;

    public Issue(Long bookId, Long readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now();
    }

    public Issue() {
        // Пустой конструктор требуется JPA
    }
}
