package com.coffee.app.spring.practice.coffee.service;

import com.coffee.app.spring.practice.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        // TODO should business logic

        Coffee createdCoffee = coffee;
        return createdCoffee;
    }

    public Coffee updateCoffee(Coffee coffee) {
        // TODO should business logic

        Coffee updatedCoffee = coffee;
        return updatedCoffee;
    }

    public Coffee findCoffee(long coffeeId) {
        // TODO should business logic

        Coffee coffee = new Coffee(1L, "아메리카노", "Americano", 3000, "AMC");
        return coffee;
    }

    public List<Coffee> findCoffees() {
        // TODO should business logic

        Coffee coffee1 = new Coffee(1L, "아메리카노", "Americano", 3000, "AMC");
        Coffee coffee2 = new Coffee(2L, "카페라떼", "Cafe Latte", 5000, "CLT");

        List<Coffee> coffees = List.of(coffee1, coffee2);
        return coffees;
    }

    public void deleteCoffee(long coffeeId) {
        // TODO should business logic

    }
}
