package com.example.tiny_url.service;

import com.example.tiny_url.model.Link;
import com.example.tiny_url.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LinkService {
    private final String baseURL;
    private final LinkRepository linkRepository;
    private final UserService userService;

    LinkService(LinkRepository linkRepository, UserService userService) {
        this.baseURL = "http://localhost:8080/";
        this.linkRepository = linkRepository;
        this.userService = userService;
    }

    public Mono<String> shortenLink(String userId, String apiKey, String originalURL) {
        String randomKey = RandomStringUtils.randomAlphabetic(5);
        return userService.getUser(userId)
                .flatMap(user -> {
                    if (user.getApiKey().equals(apiKey)) {
                        return linkRepository.save(new Link(originalURL, randomKey))
                                .map(result -> baseURL + result.getKey());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    public Mono<String> getOriginalLink(String key) {
        return linkRepository.findByKey(key);
    }
}
