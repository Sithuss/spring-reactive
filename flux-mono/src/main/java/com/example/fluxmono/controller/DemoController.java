package com.example.fluxmono.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public Flux<Integer> demo() {
        return Flux.fromStream(
                Stream.of(1,2,3,4,5,6,7,8,9)
        ).delayElements(Duration.ofSeconds(3));
    }
}
