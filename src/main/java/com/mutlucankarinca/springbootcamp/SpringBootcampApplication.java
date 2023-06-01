package com.mutlucankarinca.springbootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootcampApplication.class, args);
	}

}
