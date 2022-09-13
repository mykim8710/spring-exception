# Spring - Exception Study Project

## Project Spec
- 프로젝트 선택
    - Project: Gradle Project
    - Spring Boot: 2.7.3
    - Language: Java
    - Packaging: Jar
    - Java: 11
- Project Metadata
    - Group: com.example
    - Artifact: exception
    - Name: spring-exception
    - Package name: com.example.exception
- Dependencies: **Spring Web**, **Lombok**, **Thymeleaf**, **Validation**


## Spring - exception
- 서블릿 예외 처리
  - Exception(예외)
  - response.sendError(HTTP 상태 코드, 오류 메시지)
  - WebServerCustomizer → 스프링 부트가 제공하는 기능을 사용해서 서블릿 오류 페이지를 등록
  - ErrorPageController : 해당 오류를 처리할 컨트롤러가 필요
  - 서블릿 예외 처리 - 오류 페이지 작동 원리
    - 1. WAS(여기까지 전파) <- 필터 <- 서블릿 <- 인터셉터 <- 컨트롤러(예외발생)
    - 2. WAS '/error-page/500' 다시 요청 -> 필터 -> 서블릿 -> 인터셉터 -> 컨트롤러(/error-page/500) -> View
- 서블릿 예외 처리 - 필터
- 서블릿 예외 처리 - 인터셉터
- 스프링 부트 - 오류 페이지 설정 및 적용