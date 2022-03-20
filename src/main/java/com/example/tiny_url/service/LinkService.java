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

    LinkService(LinkRepository linkRepository) {
        this.baseURL = "http://localhost:8080/";
        this.linkRepository = linkRepository;
    }

    public Mono<String> shortenLink(String url) {
        String randomKey = RandomStringUtils.randomAlphabetic(5);
        return linkRepository.save(new Link(url, randomKey))
                .map(result -> baseURL + result.getKey());
    }

    public Mono<String> getOriginalLink(String key) {
        return linkRepository.findByKey(key);
    }
}
