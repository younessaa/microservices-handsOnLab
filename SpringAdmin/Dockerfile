FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} microservice-springadmin.jar
ENTRYPOINT ["java","-jar","/microservice-springadmin.jar"]
EXPOSE 9105