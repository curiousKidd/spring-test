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

// export default function () {
//   let delay = 1000; // 1초 (1000ms) 지연
//   let vt_url = `http://localhost:8080/vt?delay=${delay}`;
//   let webflux_url = `http://localhost:8080/webflux?delay=${delay}`;

//   // ✅ 두 API를 병렬로 요청
//   let responses = http.batch([
//     ["GET", vt_url, null, { tags: { api: "VirtualThread" } }],
//     ["GET", webflux_url, null, { tags: { api: "WebFlux" } }],
//   ]);

//   // ✅ 응답 코드 확인 (200 OK인지 체크)
//   check(responses[0], { "VT API 응답이 200": (res) => res.status === 200 });
//   check(responses[1], {
//     "WebFlux API 응답이 200": (res) => res.status === 200,
//   });

//   // ✅ 응답 시간 출력
//   console.log(
//     `Virtual Thread Response Time: ${responses[0].timings.duration} ms`
//   );
//   console.log(`WebFlux Response Time: ${responses[1].timings.duration} ms`);

//   sleep(1); // 1초 쉬고 다음 요청
// }

// vus: 10 → 10명의 동시 사용자가 요청을 보냄
// duration: '10s' → 10초 동안 테스트
// http.get('http://localhost:8080/vt?delay=1000') → Virtual Thread API 호출
// console.log(res.timings.duration) → 응답 시간 로깅
