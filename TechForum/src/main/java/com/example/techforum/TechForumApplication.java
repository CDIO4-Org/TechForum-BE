package com.example.techforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.model")
public class TechForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechForumApplication.class, args);
	}

}
