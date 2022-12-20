package com.coffee.app.spring.practice.coffee.dto;

import com.coffee.app.spring.practice.coffee.entity.Coffee;
import com.coffee.app.spring.practice.coffee.entity.Coffee.CoffeeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CoffeeResponseDto {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private String coffeeCode;
    private CoffeeStatus coffeeStatus;

    public String getCoffeeStatus() {
        return coffeeStatus.getStatus();
    }
}
