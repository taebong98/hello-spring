package com.coffee.app.spring.practice.order.mapper;

import com.coffee.app.spring.practice.order.dto.OrderPostDto;
import com.coffee.app.spring.practice.order.dto.OrderResponseDto;
import com.coffee.app.spring.practice.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    OrderResponseDto orderToOrderResponseDto(Order order);
}
