FROM openjdk:11-slim as build

MAINTAINER MohammadTaghipour

COPY target/transaction-0.0.1-SNAPSHOT.jar transaction-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/transaction-0.0.1-SNAPSHOT.jar"]