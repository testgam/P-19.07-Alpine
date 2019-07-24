# P-19.07-Alpine
P-19.07-Alpine
## 환경
- Spring framework
- junit4
- vscode

## 구현 레벨
- 회원가입/로그인
- 책 검색
- 검색된 책의 상세 조회
- 내 검색 히스토리
- 인기 키워드 목록

## 우대 사항 관련 및 추가 구현 필요
- 카카오검색 API, 검색횟수 API 에 cache 적용 완료 
- `TODO` 동시성 이슈 -> customevent 로 비동기 처리 구현 필요
- `TODO` 카카오 검색 API 장애시 네이버 API로 fallback 구현 필요
- `TODO` 에러 처리 및 로깅 미흡

## 실행 (default port: 8080)
`java -jar p1907-0.0.1-SNAPSHOT.jar`

## 라이브러리 목록
- spring-boot
- spring-boot-stater-actuator : 서비스 관리 목적으로 추가함
  - http://localhost:8080/actuator/health
- spring-boot-stater-data-jpa, queryDsl, h2 : DB 및 JPA 관련 구현에 필요
- thymeleaf : spring-boot 기본 템플릿 엔진
- spring-boot-stater-security : 로그인 구현에 사용
- lombok : 어노테이션 기반, 코드 간소화 생산성을 위해 사용
- swagger : API 양이 많아질 것에 대비해 적용했지만 실제 사용하진 않음
- spring-boot-stater-test : Mock 기반 junit 테스트에 사용
- spring-boot-stater-chace : 실시간성이 아닌 데이터에 대해 임시로 캐싱하려고 사용함