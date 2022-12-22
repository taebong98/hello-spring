package com.coffee.app.spring.practice.order.service;

import com.coffee.app.spring.practice.coffee.service.CoffeeService;
import com.coffee.app.spring.practice.exception.BusinessLogicException;
import com.coffee.app.spring.practice.exception.ExceptionCode;
import com.coffee.app.spring.practice.member.service.MemberService;
import com.coffee.app.spring.practice.order.entity.Order;
import com.coffee.app.spring.practice.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final MemberService memberService;
    private final CoffeeService coffeeService;
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        verifyOrder(order);
        Order saveOrder = saveOrder(order);

        return saveOrder;
    }

    public Order updateOrder(Order order) {
        Order findOrder = findOrder(order);

        Optional.ofNullable(order.getOrderStatus())
                .ifPresent(orderStatus -> findOrder.setOrderStatus(orderStatus));

        return orderRepository.save(findOrder);
    }


    private void verifyOrder(Order order) {
        memberService.findMember(order.getMember().getMemberId());

        order.getOrderCoffees().stream()
                .forEach(orderCoffee -> coffeeService.
                        findVerifiedCoffee(orderCoffee.getCoffee().getCoffeeId()));
    }

    private Order findOrder(Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(order.getOrderId());
        Order findOrder = optionalOrder.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
        return findOrder;
    }

    private Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
