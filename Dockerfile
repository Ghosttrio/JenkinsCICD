FROM openjdk:11-jdk
COPY build/libs/test-0.0.1-SNAPSHOT.jar
CMD ["java","-jar", test-0.0.1-SNAPSHOT.jar]