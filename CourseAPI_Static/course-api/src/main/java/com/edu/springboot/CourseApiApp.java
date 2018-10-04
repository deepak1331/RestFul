package com.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		System.out.println("My First Spring boot app");
		SpringApplication.run(CourseApiApp.class, args);
	}

}
