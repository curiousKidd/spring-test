package com.spring.rx_java;

import reactor.core.publisher.Flux;

public class ReactorExample {
    public static void main(String[] args) {
        // 1. Flux를 생성하여 1부터 5까지의 숫자를 emit합니다.
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);

        // 2. 각 숫자를 두 배로 변환합니다.
        numbers
                .map(i -> i * 2)
                // 3. subscribe()를 통해 결과를 출력합니다.
                .subscribe(
                        item -> System.out.println("Reactor Result: " + item),  // 데이터 처리
                        error -> System.err.println("Error: " + error),           // 에러 처리
                        () -> System.out.println("Reactor Completed")             // 완료 시 실행
                );
    }
}
