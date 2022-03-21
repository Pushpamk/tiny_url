package com.example.tiny_url.controller;

import com.example.tiny_url.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping(value = "link/create", produces = "application/json")
    Mono<ResponseEntity<String>> createShortLink(@RequestBody CreateShortLinkRequest request) {
        return linkService.shortenLink(request.getUserId(), request.getApiKey(), request.getOriginalURL())
                .map(ResponseEntity::ok);
    }

    @GetMapping(value = "link/{key}", produces = "application/json")
    Mono<ResponseEntity<String>> getOriginalLink(@PathVariable String key) {
        return linkService.getOriginalLink(key)
                .map(ResponseEntity::ok);
    }


    public static class CreateShortLinkRequest {
        private String originalURL;
        private String apiKey;
        private String userId;

        CreateShortLinkRequest() {}

        CreateShortLinkRequest(String originalURL, String apiKey, String userId) {
            this.userId = userId;
            this.apiKey = apiKey;
            this.originalURL = originalURL;
        }

        public void setOriginalURL(String originalURL) { this.originalURL = originalURL; }

        public void setApiKey(String apiKey) { this.apiKey = apiKey; }

        public void setUserId(String userId) { this.userId = userId; }

        public String getOriginalURL() { return originalURL; }

        public String getApiKey() { return apiKey; }

        public String getUserId() { return userId; }
    }
}
