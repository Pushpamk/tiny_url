package com.example.tiny_url.service;

import com.example.tiny_url.model.User;
import com.example.tiny_url.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> registerUser(String name) {
        Mono<User> save = userRepository.save(new User(name));
        return save;
    }

    public Mono<User> getUser(String id) {
        return userRepository.findById(id);
    }
}
