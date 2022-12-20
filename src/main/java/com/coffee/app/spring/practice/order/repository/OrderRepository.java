package com.coffee.app.spring.practice.order.repository;

import com.coffee.app.spring.practice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
