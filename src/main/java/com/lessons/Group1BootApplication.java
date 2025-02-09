package com.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lessons.service")
public class Group1BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group1BootApplication.class, args);
	}

}
