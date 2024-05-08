package com.service.servicediscoveryregistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryRegistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryRegistoryApplication.class, args);
	}

}
