package com.example.tiny_url.controller;

import com.example.tiny_url.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * <h1>LinkController</h1>
 * @author Pushpam Kumar
 * A LinkController class handles the request related to short link creation and getting original link from the short url
 */

@RestController
@RequestMapping("/api/v1/link")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    /**
     * This method is used to handle POST request on /api/v1/link/create.
     * @param request This is parameter of type CreateShortLinkRequest
     * @return Mono<ResponseEntity<String>> This returns the OK(200) response(with shortLink) if authentication succeed else 403 status
     */
    @PostMapping(value = "/create", produces = "application/json")
    Mono<ResponseEntity<String>> createShortLink(@RequestBody CreateShortLinkRequest request) {
        return linkService.shortenLink(request.getUserId(), request.getApiKey(), request.getOriginalURL())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build());
    }

    /**
     * This method is used to handle GET request on /api/v1/link/{key}.
     * @param key This is parameter of type String, which contains shortLink key.
     * @return Mono<ResponseEntity<String>> This returns the original URL provided short link key if found else 404 not found
     */
    @GetMapping(value = "/{key}", produces = "application/json")
     Mono<ResponseEntity<String>> getOriginalLink(@PathVariable String key) {
        return linkService.getOriginalLink(key)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    /**
     * A class which implements how the Create Short link request should be.
     */
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
