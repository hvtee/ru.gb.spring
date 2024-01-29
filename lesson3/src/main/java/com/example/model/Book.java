package com.example.model;

import lombok.*;

@Data
@RequiredArgsConstructor
public class Book {
    public static long sequence = 1L;
    private final long id;
    private final String name;

    public Book(String name) {
        this(sequence++, name);
    }
}

