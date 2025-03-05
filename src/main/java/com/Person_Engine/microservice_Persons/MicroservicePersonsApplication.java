package com.Person_Engine.microservice_Persons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePersonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePersonsApplication.class, args);
	}

}
