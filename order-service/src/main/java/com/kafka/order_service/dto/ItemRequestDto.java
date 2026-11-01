package com.kafka.order_service.dto;

import java.math.BigDecimal;

public record ItemRequestDto(
        Long productId,
        Integer quantity,
        BigDecimal price
) {
}