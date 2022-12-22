package com.coffee.app.spring.practice.order.dto;

import com.coffee.app.spring.practice.order.entity.Order;

public class OrderPatchDto {
    private long orderId;
    private Order.OrderStatus orderStatus;

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
