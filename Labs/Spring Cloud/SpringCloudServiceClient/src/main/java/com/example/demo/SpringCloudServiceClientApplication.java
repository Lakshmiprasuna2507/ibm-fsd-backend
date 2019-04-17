package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class SpringCloudServiceClientApplication {
	
	@Autowired
	DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceClientApplication.class, args);
	}
	
public void run(String args)throws Exception{
	
	String baseUrl = "http://localhost:8080/";
	
	RestTemplate client = new RestTemplate();
	List<ServiceInstance>instances=discoveryClient.getInstances("EurekaClient");
	
	RequestEntity<String> request = new RequestEntity(HttpMethod.GET,new URI(baseUrl));
	ResponseEntity<String> response=client.exchange(request,String.class);
	
	System.out.println(response.getBody());
	
}
}
