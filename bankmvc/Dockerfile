FROM java:8-jdk-alpine
EXPOSE 8080
ADD target/bank-app.war bank-app.war
ENTRYPOINT ["java","-jar","/bank-app.war"]