package com.coffee.app.spring.practice.coffee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CoffeePatchDto {
    private String korName;
    private String engName;
    private int price;
    private String coffeeCode;
}
