package com.coffee.app.spring.practice.order.entity;


import com.coffee.app.spring.practice.coffee.entity.Coffee;

import javax.persistence.*;

@Entity
public class OrderCoffee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderCoffeeId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;
}
