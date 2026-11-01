package com.kafka.order_service.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public record OrderResponseDto(
        Long orderId,
        UUID customerId,
        List<ItemRequestDto> items,
        BigDecimal totalAmount,
        String status,
        LocalDateTime createdAt
) {
}