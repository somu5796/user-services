package com.microservices.user_services.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

@Entity
@Getter
@Setter
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    public User() {
    }

    // Constructor with parameters (optional, for convenience)
    public User(String userName, String address) {
        this.name = userName;
        this.address = address;
    }
    public User(Long id ,String userName, String address) {
        this.id=id;
        this.name = userName;
        this.address = address;
    }
}
