# wallet
E-Wallet has been implementing base on micorservices architecture.
------------------------------
The project has used spring boot, spring cloud for implementing.
Tool requirement for running project:
1. Oracle JDK 11
2. Maven 3
3. Docker

Instruction for deploying and running project:

1. run following command in these directories(wallet/configserver, wallet/discoveryserver, wallet/gateway)

mvn clean package

Notice: configserver, discoveryserver and gateway are none functional services which another services use these services therefore we have to build and run these services before build and run another services.

    1.1 build and run configserver(manage properties files for all services)
    1.2 build and run discoveryserver(All services should register in discoveryserver because we want find services by name, we don't use IP and Port for comunicating between services therefor we can add same services without concern therfore discover serve making easy some important issue, for example scaling)
    1.3 build and run gateway(route all request from client to our services therefor we can handle monitoring, log and security issus)

2. Make sure config server and discovery server are up before run following command in wallet directory because for running test case, services need fetch properties files from configserver and register in discovery server:

mvn clean package

3. we should down configserver and discoveryserver

Now we can do last step :)

4. run following command in /wallet directory and wait about 10 minute after that you can test wallet services

docker-compose up -d

All steps can be done with CI/CD, but I need to do and run the project with Java and Docker as per the instructions in the documentation
