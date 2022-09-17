# wallet
E-Wallet has been implementing base on micorservices architecture.
------------------------------
The project has used spring boot, spring cloud for implementing.
Tool requirement for running project:
1. Oracle JDK 11
2. Maven 3
3. Docker

Instruction for deploying and running project:

1. Run following command in these directories(/wallet/configserver, /wallet/discoveryserver, /wallet/gateway and /wallet)

mvn clean package

Notice:

    1.1 configserver(manage properties files for all services)
    1.2 discoveryserver(All services should register in discoveryserver because we want find services by name, we don't use IP and Port for comunicating between services therefor we can add same services without concern therfore discover serve making easy some important issue, for example scaling)
    1.3 gateway(route all request from client to our services therefor we can handle monitoring, log and security issus)

Now we can do last step :)

2. run following command in /wallet directory and wait about 10 minute after that you can test wallet services

docker-compose up -d

All steps can be done with CI/CD, but I need to do and run the project with Java and Docker according to document

3. You can import postman file collection for test wallet services(The file is in root of project)

====================================================================================================================
=> Idempotency implemented by using UUID and set unique transactionId column in DB.
=> Atomicity implemented by using spring Transactional annotation(we can implement atomicity in complex transaction in microservices by saga pattern).
=> Scalability implemented by spring cloud, we can use kubernetes for scaling but according to document, we can't use kubernetes therefore I use Eureka and feign client and docker compose for scaling.