FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} commandes-service.jar
ENTRYPOINT ["java","-jar","/commandes-service.jar"]
EXPOSE 9002