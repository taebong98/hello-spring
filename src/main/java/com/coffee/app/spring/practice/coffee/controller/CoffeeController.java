package com.coffee.app.spring.practice.coffee.controller;


import com.coffee.app.spring.practice.coffee.dto.CoffeePatchDto;
import com.coffee.app.spring.practice.coffee.dto.CoffeePostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {
        // 비즈니스 로직 적용 필요

        return new ResponseEntity(coffeePostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@Valid @PathVariable("coffee-id") @Min(1) long coffeeId,
                                      @RequestBody CoffeePatchDto coffeePatchDto) {
        // 비즈니스 로직 적용 필요
        return new ResponseEntity<>(coffeePatchDto, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") @Min(1) long coffeeId) {
        // 비즈니스 로직 적용 필요

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") @Min(1) long coffeeId) {
        System.out.println("# delete Coffees");

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
