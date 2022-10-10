FROM openjdk:8

ARG JAR_FILE=/target/*.jar

COPY ${JAR_FILE} FaresService.jar

ENTRYPOINT ["java","-jar","FaresService.jar"]

EXPOSE 8081