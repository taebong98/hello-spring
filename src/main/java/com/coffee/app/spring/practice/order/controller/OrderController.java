package com.coffee.app.spring.practice.order.controller;

import com.coffee.app.spring.practice.order.dto.OrderPostDto;
import com.coffee.app.spring.practice.order.entity.Order;
import com.coffee.app.spring.practice.order.mapper.OrderMapper;
import com.coffee.app.spring.practice.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderMapper mapper;
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity postOrder(@RequestBody OrderPostDto orderPostDto) {
        Order order = mapper.orderPostDtoToOrder(orderPostDto);
        Order response = orderService.createOrder(order);

        return new ResponseEntity(mapper.orderToOrderResponseDto(response), HttpStatus.CREATED);
    }
}
