package com.example.adminio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdminioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminioApplication.class, args);
	}

}
