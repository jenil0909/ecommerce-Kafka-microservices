package com.kafka.order_service.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CreateOrderRequestDto(
        UUID customerId,
        List<ItemRequestDto> items
) {
}

