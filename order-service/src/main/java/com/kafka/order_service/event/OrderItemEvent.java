package com.kafka.order_service.event;

public record OrderItemEvent(
        Long productId,
        Integer quantity
) {
}