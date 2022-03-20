package com.example.tiny_url.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String name;
    private String apiKey;

    public User(String name) {
        this.name = name;
        this.id = String.valueOf(900000000 + new Random().nextInt(1000000000));
        this.apiKey = String.valueOf(900000000 + new Random().nextInt(1000000000));
    }

    public String getName(String name) {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName() {
        this.name = name;
    }
}
