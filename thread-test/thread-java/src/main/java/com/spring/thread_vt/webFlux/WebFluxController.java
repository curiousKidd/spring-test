package com.spring.thread_vt.webFlux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WebFluxController {

    @GetMapping("/webflux")
    public Mono<String> handleRequest(@RequestParam(defaultValue = "1000") long delay) {
        System.out.println("webflux");
        long startTime = System.nanoTime();
        return Mono.delay(Duration.ofMillis(delay))
                .map(ignore -> {
                    long endTime = System.nanoTime();
                    return "WebFlux Response: " + (endTime - startTime) / 1_000_000 + " ms";
                });
    }

}
