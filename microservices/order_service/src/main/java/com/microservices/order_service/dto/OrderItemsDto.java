package com.microservices.order_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsDto {

    private Long id;
    private String productCode;
    private BigDecimal price;
    private Integer quantity;
}
