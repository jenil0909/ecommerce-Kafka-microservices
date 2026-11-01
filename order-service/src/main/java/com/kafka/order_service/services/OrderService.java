package com.kafka.order_service.services;

import com.kafka.order_service.config.AppConfig;
import com.kafka.order_service.dto.CreateOrderRequestDto;
import com.kafka.order_service.entity.Items;
import com.kafka.order_service.entity.Order;
import com.kafka.order_service.entity.Status;
import com.kafka.order_service.event.OrderCreatedEvent;
import com.kafka.order_service.repository.OrderRepository;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    @Value("${kafka.topics.order-created}")
    private String ORDER_CREATE_TOPIC;

    private final AppConfig appConfig;
    private final OrderRepository orderRepository;
    private final KafkaTemplate<Long, OrderCreatedEvent> kafkaTemplate;

    public void createOrder(CreateOrderRequestDto createOrderRequestDto) {

        List<Items> items =
                appConfig.itemRequestDtoToItem(createOrderRequestDto.items());

        BigDecimal totalAmount = items.stream().map(item->item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);


        Order order = Order.builder()
                .customerId(createOrderRequestDto.customerId())
                .items(items)
                .status(Status.CREATED)
                .totalAmount(totalAmount)
                .createdAt(LocalDateTime.now())
                .build();

        Order savedOrder =
                orderRepository.save(order);

        log.info("Order created successfully with ID: {}", savedOrder.getOrderId());

        OrderCreatedEvent orderCreatedEvent = appConfig.orderToOrderCreatedEvent(savedOrder);




    }

}
