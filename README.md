# Spring DI 실습 1 (XML 기반 DI) - 개념 정리 및 경로

간단한 쇼핑카트 시스템을 Spring XML 설정으로 DI(Dependency Injection) 연습한 과제입니다.

## ✅ 과제 요구사항 요약
- Product 2개를 Spring Bean으로 등록
  - product1: **setter injection**
  - product2: **constructor injection**
- ShoppingCart Bean 등록 후 `products(List<Product>)`를 **list로 주입**
- OrderService Bean 등록 후 `shoppingCart`를 **property(ref)로 주입**
- JUnit 테스트로 DI 정상 동작 검증

---

## 📁 파일 경로 (제출 확인용)

### 1) Java Source (main)
- `src/main/java/mylab/order/di/xml/Product.java`
- `src/main/java/mylab/order/di/xml/ShoppingCart.java`
- `src/main/java/mylab/order/di/xml/OrderService.java`

### 2) Spring XML 설정 (resources)
- `src/main/resources/mylab-order-di.xml`

### 3) Test 코드 (test)
- `src/test/java/mylab/order/di/xml/OrderSpringTest.java`

---

## ▶ 실행 방법

### 1) 과제 테스트만 실행 (추천)
```bash
./gradlew test --tests "mylab.order.di.xml.OrderSpringTest"
