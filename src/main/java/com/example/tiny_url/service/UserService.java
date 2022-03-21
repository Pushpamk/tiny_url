package com.example.tiny_url.service;

import com.example.tiny_url.model.User;
import com.example.tiny_url.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * <h1>UserService</h1>
 * @author Pushpam Kumar
 * A Service which deals user database eg. creating user, getting user etc etc.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * A method which is used to register new user.
     * @param name The name of the new user
     * @return Mono<User> Returns the details of created user.
     */
    public Mono<User> registerUser(String name) {
        Mono<User> save = userRepository.save(new User(name));
        return save;
    }

    /**
     * A method to get the user details by id
     * @param id id of the user to search
     * @return Mono<User> Returns the details of the user
     */
    public Mono<User> getUser(String id) {
        return userRepository.findById(id);
    }
}
