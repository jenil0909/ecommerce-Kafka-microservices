package com.kafka.order_service.config;

import com.kafka.order_service.dto.CreateOrderRequestDto;
import com.kafka.order_service.dto.ItemRequestDto;
import com.kafka.order_service.dto.OrderResponseDto;
import com.kafka.order_service.entity.Items;
import com.kafka.order_service.entity.Order;
import com.kafka.order_service.event.OrderCreatedEvent;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AppConfig {

    Items itemRequestDtoToItem(ItemRequestDto itemRequestDto);

    Order createOrderRequestDtoToOrder(CreateOrderRequestDto createOrderRequestDto);

    List<Items> itemRequestDtoToItem(List<ItemRequestDto> dto);

    //to Event
    OrderCreatedEvent orderToOrderCreatedEvent(Order order);

    //Response
    OrderResponseDto orderToOrderResponseDto(Order order);

}
