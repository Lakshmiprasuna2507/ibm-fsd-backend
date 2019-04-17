package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRegistryServerApplication.class, args);
	}
	@RequestMapping("/")
	public String greeting()
	{
		return "welcome greetings from Eureka server";
		
	}

}
