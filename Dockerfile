FROM openjdk:11-jdk
ARG JAR_FILE=test-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mason.jar
ENTRYPOINT ["java","-jar","/mason.jar"]
