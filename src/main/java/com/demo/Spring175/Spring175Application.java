package com.demo.Spring175;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
	
	
@SpringBootApplication	
@ComponentScan("com.tka.controller")
@EntityScan("com.tka.entity")	
public class Spring175Application {		

	public static void main(String[] args) {
		SpringApplication.run(Spring175Application.class, args);
		System.err.println("Congratulations....Spring Boot Application is Running.....");
	
	}

}
