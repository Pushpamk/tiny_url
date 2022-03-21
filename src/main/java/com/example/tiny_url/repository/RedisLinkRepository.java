package com.example.tiny_url.repository;

import com.example.tiny_url.model.Link;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class RedisLinkRepository implements LinkRepository{
    private final ReactiveRedisOperations<String, String> operations;

    RedisLinkRepository(ReactiveRedisOperations<String, String> operations) {
        this.operations = operations;
    }

    @Override
    public Mono<Link> save(Link link){
        return operations.opsForValue()
                .set(link.getKey(), link.getOriginalURL())
                .map(__ -> link);
    }

    @Override
    public Mono<String> findByKey(String key) {
        return operations.opsForValue()
                .get(key);
    }
}
