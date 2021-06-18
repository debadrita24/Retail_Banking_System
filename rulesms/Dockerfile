FROM java:8-jdk-alpine
EXPOSE 8090
ADD target/rules-service.jar rules-service.jar
ENTRYPOINT ["java","-jar","/rules-service.jar"]