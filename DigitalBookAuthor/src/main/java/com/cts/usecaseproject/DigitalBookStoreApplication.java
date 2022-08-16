package com.cts.usecaseproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
//@EnableFeignClients
public class DigitalBookStoreApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DigitalBookStoreApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
}
