FROM openjdk:11-slim as build

MAINTAINER MohammadTaghipour

COPY target/player-0.0.1-SNAPSHOT.jar player-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/player-0.0.1-SNAPSHOT.jar"]