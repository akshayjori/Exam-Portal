package com.cognizant.examportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com*")
public class ExamportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

}
