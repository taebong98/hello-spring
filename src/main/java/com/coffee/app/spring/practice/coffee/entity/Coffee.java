package com.coffee.app.spring.practice.coffee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Coffee {
    @Id
    @GeneratedValue
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private String coffeeCode;
}
