package com.coffee.app.spring.practice.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CoffeeResponseDto {
    private String korName;
    private String engName;
    private int price;
    private String coffeeCode;
}
