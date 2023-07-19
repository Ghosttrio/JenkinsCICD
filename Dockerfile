FROM openjdk:11-jdk
COPY build/libs/jenkins-0.0.1-SNAPSHOT.jar
CMD ["java","-jar",jenkins-0.0.1-SNAPSHOT.jar]