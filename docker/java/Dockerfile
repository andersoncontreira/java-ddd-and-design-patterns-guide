FROM openjdk:8-jdk-alpine

ARG PROJECT_NAME=training-ddd-and-design-patterns-java
ARG ENVIRONMENT_NAME=development
ARG JAR_FILE=jar/training-full.jar

COPY ${JAR_FILE} app.jar

CMD ["java","-jar","/app.jar"]