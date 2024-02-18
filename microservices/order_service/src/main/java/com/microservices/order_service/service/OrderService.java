package com.microservices.order_service.service;


import com.microservices.order_service.dto.OrderItemsDto;
import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.model.Order;
import com.microservices.order_service.model.OrderItems;
import com.microservices.order_service.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepo orderRepo;

    public void placeOrder(OrderRequest orderRequest){

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItems = orderRequest.getOrderItemsDto()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderItemsList(orderItems);
        orderRepo.save(order);
    }

    private OrderItems mapToDto(OrderItemsDto orderItemsDto) {
        OrderItems orderItems = new OrderItems();
        orderItems.setPrice(orderItemsDto.getPrice());
        orderItems.setQuantity(orderItemsDto.getQuantity());
        orderItems.setProductCode(orderItemsDto.getProductCode());
        return orderItems;

    }
}
