FROM openjdk:21-jdk-slim
WORKDIR /app
COPY smartcamp/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
