package com.example.tiny_url.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String name;
    private String apiKey;

    public User(String name) {
        this.name = name;
        this.id = UUID.
                randomUUID().
                toString();
        this.apiKey = UUID.
                randomUUID().
                toString()
                .replaceAll("-", "");
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
