package com.example.tiny_url.repository;

import com.example.tiny_url.model.Link;
import reactor.core.publisher.Mono;

public interface LinkRepository {
    Mono<Link> save(Link link);
    Mono<String> findByKey(String key);
}
