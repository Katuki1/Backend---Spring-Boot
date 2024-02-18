package com.microservices.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

		System.out.println("PRODUCT-SERVICE INITIALIZED SUCCESSFULLY ON " + new Date());
	}

}
