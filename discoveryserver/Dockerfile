FROM openjdk:11-slim as build

MAINTAINER MohammadTaghipour

COPY target/discoveryserver-0.0.1-SNAPSHOT.jar discoveryserver-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/discoveryserver-0.0.1-SNAPSHOT.jar"]