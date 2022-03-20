package com.example.tiny_url.model;

public class Link {
    private String originalLink;
    private String key;

    public Link(String originalLink, String key) {
        this.originalLink = originalLink;
        this.key = key;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public String getKey() {
        return key;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
