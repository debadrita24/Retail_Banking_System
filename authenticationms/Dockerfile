FROM java:8-jdk-alpine
EXPOSE 8084
ADD target/auth-app.jar auth-app.jar
ENTRYPOINT ["java","-jar","/auth-app.jar"]