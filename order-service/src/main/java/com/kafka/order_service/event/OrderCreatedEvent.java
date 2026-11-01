package com.kafka.order_service.event;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderCreatedEvent(
        Long orderId,
        UUID customerId,
        List<OrderItemEvent> items,
        BigDecimal totalAmount
) {
}