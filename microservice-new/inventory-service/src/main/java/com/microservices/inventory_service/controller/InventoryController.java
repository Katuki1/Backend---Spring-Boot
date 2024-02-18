package com.microservices.inventory_service.controller;

import com.microservices.inventory_service.dto.InventoryResponse;
import com.microservices.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //path - http://localhost:8083/api/inventory/samsung1,tecno1
    //requestparam- http://localhost:8083/api/inventory?product_code=samsung1&productcode=tecno1

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> productCode){
        return inventoryService.isInStock(productCode);
    }


//    @GetMapping("/{product_code}")
//    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@PathVariable("product_code") String productCode){
//        return inventoryService.isInStock(productCode);
//    }

}
