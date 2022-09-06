# wallet
E-Wallet has been implementing base on micorservices architecture.
------------------------------
The project has used spring boot and spring cloud for implementing.
Tool requirement for running project:
1. Oracle JDK 11
2. Maven 3
3. Docker

Instruction for deploying and running project:

1. run below command in these directories(wallet and wallet/configserver and wallet/gateway and wallet/discoveryserver)

mvn clean package -DskipTests

3. run below command in /wallet and wait about 5 minute after that you can test wallet services

docker-compose up -d
