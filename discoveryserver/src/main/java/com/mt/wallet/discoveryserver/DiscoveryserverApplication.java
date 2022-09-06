package com.mt.wallet.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Mohammad Taghipour
 * @Date 8/26/2022
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryserverApplication.class, args);
	}

}
