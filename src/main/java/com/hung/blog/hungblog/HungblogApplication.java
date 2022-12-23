package com.hung.blog.hungblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HungblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(HungblogApplication.class, args);
	}

}
