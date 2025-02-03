package com.spring.thread_vt.VT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController()
public class VirtualThreadController {

    private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        @GetMapping("/vt")
        public CompletableFuture<String> handleRequest(@RequestParam(defaultValue = "1000") long delay) {
            System.out.println("VT");
            long startTime = System.nanoTime();  // ✅ 요청 시작 시간 기록

            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(delay);  // ✅ 요청당 1초 지연 (I/O 작업 시뮬레이션)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long endTime = System.nanoTime();  // ✅ 요청 종료 시간 기록
                long duration = (endTime - startTime) / 1_000_000;  // 밀리초 변환
                return "Virtual Thread Response: " + duration + " ms";
            }, executor);
        }
}
