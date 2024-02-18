package com.microservices.inventory_service.service;

import com.microservices.inventory_service.dto.InventoryResponse;
import com.microservices.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> productCode){
        return inventoryRepository.findByProductCodeIn(productCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .productCode(inventory.getProductCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();

//        return inventoryRepository.findByProductCode(productCode).isPresent();
    }
}
