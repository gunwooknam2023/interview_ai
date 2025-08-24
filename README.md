# 🤖 AI 커리어 코치 챗봇 API (AI Career Coach Chatbot API)

**이력서 정보 하나로, AI가 당신의 취업 준비를 실시간으로 코칭합니다.**

[![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Google Gemini](https://img.shields.io/badge/Google_Gemini-AI-4285F4?style=for-the-badge&logo=google&logoColor=white)](https://ai.google/discover/gemini/)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)](https://junit.org/junit5/)

<br>

## 목차

- [📌 프로젝트 소개](#-프로젝트-소개)
- [✨ 주요 기능](#-주요-기능)
- [🛠️ 기술 스택](#-기술-스택)
- [📡 API 명세](#-api-명세)
- [🚀 시작하기](#-시작하기)
- [💻 사용 예시](#-사용-예시)

<br>

## 📌 프로젝트 소개

구직자의 성공적인 취업 준비를 돕기 위해 설계된 백엔드 API입니다.

사용자가 자신의 **이력서 핵심 정보(경력 요약, 수행 직무, 보유 기술)를 텍스트로 입력**하면, Google Gemini AI가 이를 분석하여 실제 면접에서 나올 법한 **심층 질문**과 앞으로의 성장을 위한 **개인 맞춤형 학습 로드맵**을 실시간으로 생성하여 제공합니다.

---

## ✨ 주요 기능

- **🤖 개인 맞춤 정보 생성**: 입력된 이력서 정보를 기반으로 모든 응답을 개인화합니다.
- **🎙️ 실전형 면접 질문 제공**: AI가 생성하는 5가지의 날카로운 면접 예상 질문을 통해 실전에 대비할 수 있습니다.
- **🗺️ 체계적인 학습 로드맵 제안**: AI가 현재 기술 스택과 경력을 분석하여 다음 단계로 나아가기 위한 구체적인 학습 경로와 방법론을 구조화된 데이터로 제공합니다.

---

## 🛠️ 기술 스택

### Backend
- **Java 17**
- **Spring Boot 3.x**
- **Spring MVC**

### AI
- **Google Gemini AI** (`com.google.genai:google-genai:1.0.0`)

### Build Tool
- **Gradle 8.x**

### Test
- **JUnit 5**
- **Mockito**
- **AssertJ**

---

## 📡 API 명세

### AI 코칭 요청 API
- `POST /api/v1/coach`
- **설명**: AI가 생성한 전체 응답을 한 번에 받는 API입니다. 응답 생성까지 5~15초가 소요될 수 있습니다.

#### **Request Body**
```json
{
    "statusCode": 200,
    "message": "요청에 성공했습니다.",
    "data": {
        "interviewQuestions": [
            "질문1: 온라인 커머스 플랫폼에서 대용량 트래픽을 경험하셨을 텐데, 쿼리 최적화를 통해 성능을 개선했던 구체적인 사례가 있나요?",
            "질문2: Redis를 어떤 용도로 사용하셨으며, 도입 전후로 어떤 성능상의 이점이 있었는지 설명해주세요.",
            "질문3: RESTful API를 설계할 때 가장 중요하게 생각하는 원칙은 무엇인가요?",
            "질문4: JPA를 사용하면서 발생했던 N+1 문제나 다른 성능 이슈를 겪고 해결해 본 경험이 있나요?",
            "질문5: Docker를 사용하여 얻었던 가장 큰 이점은 무엇이었고, AWS 환경에서 어떻게 활용하셨나요?"
        ],
        "learningPath": [
            {
                "sectionTitle": "Spring Boot 심화 및 MSA 기초",
                "topics": ["Spring Actuator를 이용한 모니터링", "Spring Cloud Gateway", "Resilience4j를 이용한 서킷 브레이커"],
                "learningGoal": "단순한 API 서버를 넘어, 안정적이고 관측 가능한 마이크로서비스를 구축할 수 있는 역량을 확보합니다.",
                "learningGuide": "'Spring Actuator' 공식 문서를 통해 엔드포인트를 학습하고, 'Baeldung' 블로그에서 'Spring Cloud Gateway' 키워드로 검색하여 실제 예제를 따라해보는 것을 추천합니다."
            },
            {
                "sectionTitle": "대용량 트래픽 처리 및 메시징 시스템",
                "topics": ["Apache Kafka 또는 RabbitMQ 기초", "비동기 메시지 처리", "이벤트 기반 아키텍처"],
                "learningGoal": "동기 방식의 한계를 이해하고, 메시지 큐를 통해 시스템 간 결합도를 낮추고 대용량 요청을 안정적으로 처리하는 능력을 기릅니다.",
                "learningGuide": "'카프카, 데이터 플랫폼의 최강자'와 같은 입문 서적을 읽거나, 관심 있는 기업의 기술 블로그에서 'Kafka 도입기'를 검색하여 실제 사용 사례를 학습하는 것이 좋습니다."
            }
        ]
    }
}
```
---

## 🚀 시작하기

### **전제 조건**
- **Java 17 (JDK 17)** 설치
- **Gradle** 설치

### **설정 및 실행**
1.  프로젝트를 로컬에 복제합니다.
    ```shell
    git clone [https://github.com/gunwooknam2023/interview_ai.git](https://github.com/gunwooknam2023/interview_ai.git)
    ```

2.  `src/main/resources/` 경로에 `application-local.yml` 파일을 생성합니다.

3.  생성한 파일 안에 자신의 Gemini API 키를 추가합니다.
    ```yaml
    gemini:
      api-key: "YOUR_GEMINI_API_KEY"
    ```

4.  프로젝트 루트 디렉토리에서 아래 명령어를 입력하여 애플리케이션을 실행합니다.
    ```shell
    ./gradlew bootRun
    ```

---

## 💻 사용 예시

### AI 코칭 요청 cURL

```shell
curl -X POST http://localhost:8080/api/v1/coach \
-H "Content-Type: application/json" \
-d '{
  "career": "2년차 백엔드 개발자, 커머스 플랫폼 개발 경험",
  "job": "Java, Spring Boot 기반 REST API 개발 및 운영",
  "skill": "Java, Spring Boot, JPA, MySQL, Redis, Docker"
}'
