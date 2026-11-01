package com.kafka.order_service.controller;

import com.kafka.order_service.dto.CreateOrderRequestDto;
import com.kafka.order_service.dto.OrderResponseDto;
import com.kafka.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    public ResponseEntity<OrderResponseDto> createOrder(CreateOrderRequestDto createOrderRequestDto) {
        orderService.createOrder(createOrderRequestDto);

        return null;
    }


}
