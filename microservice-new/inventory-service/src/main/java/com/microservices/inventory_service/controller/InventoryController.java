package com.microservices.inventory_service.controller;

import com.microservices.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{product_code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("product_code") String productCode){
        return inventoryService.isInStock(productCode);
    }

}
