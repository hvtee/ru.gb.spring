package com.example.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@Schema(name = "Model for users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password")
    private String password;

    //    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable
    @Column(name = "roles")
    private String role;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public <E> User(String name, String password, List<E> es) {
        this.name = name;
        this.password = password;
        this.role = es.toString();
    }
}
