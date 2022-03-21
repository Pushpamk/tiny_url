package com.example.tiny_url.model;

public class Link {
    private String originalURL;
    private String key;

    public Link(String originalLink, String key) {
        this.originalURL = originalLink;
        this.key = key;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public String getKey() {
        return key;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
