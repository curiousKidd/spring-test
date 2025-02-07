import http from "k6/http";
import { sleep } from "k6";

export let options = {
  vus: 1000, // 동시 사용자 수 (Virtual Users)
  duration: "10s", // 테스트 실행 시간
};

export default function () {
  // let res = http.get("http://localhost:8080/webflux?delay=1000"); // Virtual Thread API 호출
  let res = http.get("http://localhost:8080/vt?delay=1000"); // Virtual Thread API 호출
  console.log(`Response VT time: ${res.timings.duration} ms`);
  sleep(1);
}

// vus: 10 → 10명의 동시 사용자가 요청을 보냄
// duration: '10s' → 10초 동안 테스트
// http.get('http://localhost:8080/vt?delay=1000') → Virtual Thread API 호출
// console.log(res.timings.duration) → 응답 시간 로깅
