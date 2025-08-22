# =================
# 1. Build Stage
# =================
# Java 17 JDK가 포함된 이미지를 사용하여 프로젝트를 빌드합니다.
FROM eclipse-temurin:17-jdk-jammy as builder

# 작업 디렉토리 설정
WORKDIR /app

# 프로젝트 파일 전체를 컨테이너 안으로 복사
COPY . .

# gradlew 실행 권한 부여 및 JAR 파일 생성 (테스트는 제외)
RUN chmod +x ./gradlew && ./gradlew bootJar -x test

# ==================
# 2. Run Stage
# ==================
# 실제 애플리케이션을 실행할 때는 더 가벼운 JRE(Java Runtime Environment) 이미지를 사용합니다.
FROM eclipse-temurin:17-jre-jammy

# 작업 디렉토리 설정
WORKDIR /app

# Build Stage에서 생성된 JAR 파일을 복사해옵니다.
# build/libs/ 경로에 있는 어떤 이름의 jar 파일이든 app.jar로 복사됩니다.
COPY --from=builder /app/build/libs/*.jar app.jar

# 애플리케이션이 8080 포트를 사용함을 명시
EXPOSE 8080

# 컨테이너가 시작될 때 이 명령어를 실행하여 애플리케이션을 구동합니다.
ENTRYPOINT ["java", "-jar", "app.jar"]