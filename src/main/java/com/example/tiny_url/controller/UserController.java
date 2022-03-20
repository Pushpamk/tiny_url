package com.example.tiny_url.controller;

import com.example.tiny_url.model.User;
import com.example.tiny_url.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/")
    private ResponseEntity<?> addUser(@RequestBody String name) {
        return ResponseEntity.ok(userRepository.save(new User(name)));
    }
}
