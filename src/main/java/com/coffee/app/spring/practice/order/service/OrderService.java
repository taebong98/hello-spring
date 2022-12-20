package com.coffee.app.spring.practice.order.service;

import com.coffee.app.spring.practice.order.entity.Order;
import com.coffee.app.spring.practice.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
