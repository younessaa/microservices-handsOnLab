FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} paiement-service.jar
ENTRYPOINT ["java","-jar","/paiement-service.jar"]
EXPOSE 9003