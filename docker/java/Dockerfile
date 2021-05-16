FROM openjdk:8-jdk-alpine

ARG PROJECT_NAME=training-ddd-and-design-patterns-java
ARG ENVIRONMENT_NAME=development

ARG JAR_FILE=./build/libs/training-ddd-and-design-patterns-java-1.0.0-SNAPSHOT.jar

COPY ${JAR_FILE} /app.jar

CMD ["java","-jar","/app.jar"]


# ARG DEPENDENCY=target/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app

# CMD ["java","-cp","app:app/lib/*","dev.andersoncontreira.trainingddd.application.Application"]

# COPY ./* /app
#
# CMD["./gradlew", "bootRun"]