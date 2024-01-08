package com.mounir.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.mounir.course.CourseApplication.class, args);
	}

}
