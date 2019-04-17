package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulServerApplication.class, args);
	}
	@GetMapping("/")
	public String home() {
		return "welcome to zuul";
	}

}
