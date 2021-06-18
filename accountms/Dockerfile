FROM java:8-jdk-alpine
EXPOSE 8086
ADD target/*account-service.jar account-service.jar
ENTRYPOINT ["java","-jar","/account-service.jar"]