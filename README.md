# Spring DI 실습1 - 경로 파익 및 요약정리

## 프로젝트 설명

Spring Framework의 Dependency Injection(XML 설정 방식)을 이용하여
주문(OrderService) - 장바구니(ShoppingCart) - 상품(Product) 구조를 구현한 실습입니다.

Spring XML 설정을 통해 객체 간 의존성을 주입하여 주문 총 금액을 계산하도록 구성했습니다.

---

## 프로젝트 구조

### Java 클래스 경로

```
src/main/java/mylab/order/di/xml/
```

포함된 클래스

```
Product.java
ShoppingCart.java
OrderService.java
```

---

### Spring 설정 파일

```
src/main/resources/
```

파일

```
mylab-order-di.xml
```

---

### 테스트 코드

```
src/test/java/mylab/order/di/xml/
```

파일

```
OrderSpringTest.java
```

---

## 클래스 역할

### Product

상품 정보를 저장하는 클래스
(id, name, price)

### ShoppingCart

상품 리스트를 보관하고 총 금액을 계산하는 클래스

### OrderService

ShoppingCart를 주입받아 주문 총 금액을 계산하는 서비스 클래스

---

## DI 방식

Spring XML 기반 Dependency Injection 사용

```
mylab-order-di.xml
```

에서 Bean을 생성하고 의존성을 주입합니다.

---

## 실행 테스트

JUnit 테스트

```
OrderSpringTest
```

를 통해 주문 총 금액 계산을 확인합니다.
