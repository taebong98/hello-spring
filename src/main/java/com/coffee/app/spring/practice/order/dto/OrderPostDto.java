package com.coffee.app.spring.practice.order.dto;

import javax.validation.constraints.Positive;

public class OrderPostDto {
    @Positive
    private long memberId;

    @Positive
    private long coffeeId;
}
