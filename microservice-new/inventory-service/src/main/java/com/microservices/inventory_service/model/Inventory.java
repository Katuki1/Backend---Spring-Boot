package com.microservices.inventory_service.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String productCode;
}
