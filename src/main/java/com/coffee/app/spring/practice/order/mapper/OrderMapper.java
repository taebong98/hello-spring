package com.coffee.app.spring.practice.order.mapper;

import com.coffee.app.spring.practice.order.dto.OrderPatchDto;
import com.coffee.app.spring.practice.order.dto.OrderPostDto;
import com.coffee.app.spring.practice.order.dto.OrderResponseDto;
import com.coffee.app.spring.practice.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);

    Order orderPatchDtoToOrder(OrderPatchDto orderPatchDto);
    OrderResponseDto orderToOrderResponseDto(Order order);
}
