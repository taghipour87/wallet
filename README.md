# wallet
E-Wallet has been implementing base on micorservices architecture.
------------------------------
The project has used spring boot and spring cloud for implementing.
Tool requirement for running project:
1. Oracle JDK 11
2. Maven 3
3. Docker

Instruction for deploying and running project:

1. run following command in these directories(wallet/configserver , wallet/gateway , wallet/discoveryserver)

mvn clean package

2. Make sure config server and discovery server are up before run following command in wallet directory:

mvn clean package

3. run following command in /wallet directory and wait about 10 minute after that you can test wallet services

docker-compose up -d
