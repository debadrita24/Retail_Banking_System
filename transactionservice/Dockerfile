FROM java:8-jdk-alpine
EXPOSE 8087
ADD target/transactionservice-0.0.1-SNAPSHOT.jar transactionservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/transactionservice-0.0.1-SNAPSHOT.jar"]