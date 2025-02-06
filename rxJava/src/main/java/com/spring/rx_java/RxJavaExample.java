package com.spring.rx_java;

import io.reactivex.rxjava3.core.Observable;

public class RxJavaExample {
    public static void main(String[] args) {
        // 1. Observable을 생성하여 1부터 5까지의 숫자를 emit합니다.
        Observable<Integer> numbers = Observable.just(1, 2, 3, 4, 5);

        // 2. 각 숫자를 두 배로 변환합니다.
        numbers
                .map(i -> i * 2)
                // 3. subscribe()를 통해 결과를 출력합니다.
                .subscribe(
                        item -> System.out.println("RxJava Result: " + item),  // 데이터 처리
                        error -> System.err.println("Error: " + error),         // 에러 처리
                        () -> System.out.println("RxJava Completed")            // 완료 시 실행
                );
    }
}
