FROM openjdk:11-slim as build

MAINTAINER MohammadTaghipour

COPY target/account-0.0.1-SNAPSHOT.jar accountResponseDto-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/account-0.0.1-SNAPSHOT.jar"]