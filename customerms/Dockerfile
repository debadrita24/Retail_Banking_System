FROM java:8-jdk-alpine
EXPOSE 8085
ADD target/CustomerService-0.0.1-SNAPSHOT.jar CustomerService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CustomerService-0.0.1-SNAPSHOT.jar"]