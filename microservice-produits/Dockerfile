FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} produits-service.jar
ENTRYPOINT ["java","-jar","/produits-service.jar"]
EXPOSE 9001