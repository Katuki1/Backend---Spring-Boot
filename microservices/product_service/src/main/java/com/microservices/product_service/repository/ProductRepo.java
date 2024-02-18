package com.microservices.product_service.repository;

import com.microservices.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
