package com.example.tiny_url.controller;

import com.example.tiny_url.model.User;
import com.example.tiny_url.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    private Mono<User> getUser(@PathVariable String id) {
        return userService.getUser(id)
                .map(user -> user);
    }

    @PostMapping(value = "/", produces = "application/json")
    private Mono<ResponseEntity<User>> addUser(@RequestBody AddUserRequest request) {
        return userService.registerUser(request.getName())
                .map(ResponseEntity::ok);
    }

    public static class AddUserRequest {
        private String name;

        AddUserRequest() {}

        AddUserRequest(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
