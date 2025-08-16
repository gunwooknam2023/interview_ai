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

본 프로젝트는 **잡코리아 AI 챌린지** 과제로 진행되었으며, 구직자의 성공적인 취업 준비를 돕기 위해 설계된 백엔드 API입니다.

사용자가 자신의 **이력서 핵심 정보(경력 요약, 수행 직무, 보유 기술)를 텍스트로 입력**하면, Google Gemini AI가 이를 분석하여 실제 면접에서 나올 법한 **심층 질문**과 앞으로의 성장을 위한 **개인 맞춤형 학습 로드맵**을 실시간으로 생성하여 제공합니다.

---

## ✨ 주요 기능

- **🤖 개인 맞춤 정보 생성**: 입력된 이력서 정보를 기반으로 모든 응답을 개인화합니다.
- **🎙️ 실전형 면접 질문 제공**: AI가 생성하는 5가지의 날카로운 면접 예상 질문을 통해 실전에 대비할 수 있습니다.
- **🗺️ 체계적인 학습 로드맵 제안**: AI가 현재 기술 스택과 경력을 분석하여 다음 단계로 나아가기 위한 구체적인 학습 경로를 구조화된 데이터로 제공합니다.
- **⚡ 실시간 스트리밍 응답**: 긴 응답을 기다릴 필요 없이, AI가 생성하는 내용을 실시간으로 받아볼 수 있습니다.

---

## 🛠️ 기술 스택

### Backend
- **Java 17**
- **Spring Boot 3.x**
- **Spring MVC** / **Spring Webflux (SseEmitter)**

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

### 1. 동기 방식 API
- `POST /api/v1/coach`
- **설명**: AI가 생성한 전체 응답을 한 번에 받는 API입니다. 응답 생성까지 15~30초가 소요될 수 있습니다.

#### **Request Body**
```json
{
  "career": "3년차 백엔드 개발자, Spring Boot/MSA/Python 기반 커머스 서비스 개발",
  "job": "주문/결제 시스템 API 개발 및 레거시 시스템 유지보수, AWS EC2 환경 운영 경험",
  "skill": "Java, Spring Boot, JPA, MySQL, Python, AWS"
}

{
    "statusCode": 200,
    "message": "요청에 성공했습니다.",
    "data": {
        "interviewQuestions": [
            "질문1: MSA 환경에서 주문/결제 시스템을 설계할 때 데이터 일관성을 어떻게 유지하셨나요?",
            "질문2: 레거시 시스템을 유지보수하면서 가장 큰 기술적 부채는 무엇이었고, 어떻게 개선을 시도했나요?",
            "질문3: Spring Boot 기반의 서비스에서 대용량 트래픽을 받았을 때를 대비한 성능 최적화 경험이 있나요?",
            "질문4: Python을 어떤 업무에 활용하셨으며, Java 생태계와 어떻게 연동했나요?",
            "질문5: AWS EC2 운영 중 발생했던 가장 기억에 남는 장애는 무엇이고, 어떻게 해결하고 재발을 방지했나요?"
        ],
        "learningPath": [
            {
                "sectionTitle": "Spring Cloud를 활용한 MSA 역량 강화",
                "topics": ["Spring Cloud Gateway", "Resilience4j를 이용한 서킷 브레이커", "Spring Cloud Config"],
                "learningGoal": "분산 환경에서의 API Gateway 구축 및 장애 허용 시스템 설계 역량을 확보합니다."
            },
            {
                "sectionTitle": "대용량 데이터 처리 및 비동기 통신",
                "topics": ["Apache Kafka 또는 RabbitMQ", "메시지 큐를 이용한 주문 처리 시스템 개선"],
                "learningGoal": "비동기 통신을 통해 시스템 간 결합도를 낮추고 대용량 트래픽을 안정적으로 처리하는 능력을 기릅니다."
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
    git clone {저장소_URL}
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

### 1. 동기 방식 API 호출

```shell
curl -X POST http://localhost:8080/api/v1/coach \
-H "Content-Type: application/json" \
-d '{
  "career": "1년차 프론트엔드 개발자",
  "job": "React와 TypeScript를 사용한 어드민 페이지 개발",
  "skill": "JavaScript, TypeScript, React, Recoil"
}'
