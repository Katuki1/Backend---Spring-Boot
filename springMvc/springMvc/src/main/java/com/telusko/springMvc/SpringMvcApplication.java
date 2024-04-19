package com.telusko.springMvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
		System.out.println("SPRING MVC-SERVICE INITIALIZED SUCCESSFULLY ON " + new Date());
	}

}
