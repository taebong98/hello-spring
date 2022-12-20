package com.coffee.app.spring.practice.order.dto;

import com.coffee.app.spring.practice.coffee.dto.CoffeeResponseDto;
import com.coffee.app.spring.practice.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter @Setter
@AllArgsConstructor
public class OrderResponseDto {
    private long orderId;
    private long memberId;
    private Order.OrderStatus orderStatus;
    private List<CoffeeResponseDto> orderCoffees;
    private LocalDateTime createdAt;
}
