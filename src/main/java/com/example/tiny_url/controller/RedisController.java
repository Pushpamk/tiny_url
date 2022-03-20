package com.example.tiny_url.controller;

import com.example.tiny_url.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class RedisController {

    private final LinkService linkService;

    public RedisController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/api/v1/link/create")
    Mono<ResponseEntity<String>> createShortLink(@RequestBody String originalLink) {
        return linkService.shortenLink(originalLink)
                .map(shortLink -> ResponseEntity.ok(shortLink));
    }

    @GetMapping("/api/v1/link/{key}")
    Mono<ResponseEntity<String>> getOriginalLink(@PathVariable String key) {
        return linkService.getOriginalLink(key)
                .map(ResponseEntity::ok);
    }

}
