FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} client-server.jar
ENTRYPOINT ["java","-jar","/client-server.jar"]
EXPOSE 8080