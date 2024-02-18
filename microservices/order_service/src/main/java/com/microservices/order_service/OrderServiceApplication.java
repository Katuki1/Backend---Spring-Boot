package com.microservices.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);

        System.out.println("ORDER-SERVICE INITIALIZED SUCCESSFULLY ON " + new Date());
}
}
