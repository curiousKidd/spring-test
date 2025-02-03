package com.spring.thread.VT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class VirtualThreadController {

    private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        @GetMapping("/vt")
        public CompletableFuture<String> handleRequest(@RequestParam(defaultValue = "1000") long delay) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(delay);  // 요청당 1초 지연 (I/O 작업 시뮬레이션)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Virtual Thread Response";
            }, executor);
        }
}
