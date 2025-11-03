package com.API_Load._esting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiLoadTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLoadTestingApplication.class, args);
	}
}
