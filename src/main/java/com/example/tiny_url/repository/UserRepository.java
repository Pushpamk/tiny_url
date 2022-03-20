package com.example.tiny_url.repository;

import com.example.tiny_url.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
