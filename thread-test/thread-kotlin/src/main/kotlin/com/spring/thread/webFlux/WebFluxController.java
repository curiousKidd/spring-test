package com.spring.thread.webFlux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/webflux")
public class WebFluxController {

    @GetMapping("/test")
    public Mono<String> handleRequest(@RequestParam(defaultValue = "1000") long delay) {
        System.out.println("testttttt");
        return Mono.delay(Duration.ofMillis(delay))  // 비동기 지연
                .thenReturn("WebFlux Response");
    }

}
