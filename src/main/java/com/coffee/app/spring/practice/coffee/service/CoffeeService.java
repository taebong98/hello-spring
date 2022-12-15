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

        return null;
    }

    public List<Coffee> findCoffees() {
        // TODO should business logic
        return null;
    }

    public void deleteCoffee(long coffeeId) {
        // TODO should business logic

    }
}
