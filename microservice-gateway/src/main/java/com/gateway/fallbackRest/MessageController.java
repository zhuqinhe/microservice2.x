package com.gateway.fallbackRest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class MessageController {

    @RequestMapping("/favoritefallback")
    public Mono<String> favoriteFallback() {
        return Mono.just("favoritefallback");
    }
    @RequestMapping("/bookmarkfallback")
    public Mono<String> bookmarkFallback() {
        return Mono.just("bookmarkfallback");
    }
}
