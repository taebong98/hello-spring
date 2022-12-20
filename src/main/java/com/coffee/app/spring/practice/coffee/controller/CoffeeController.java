package com.coffee.app.spring.practice.coffee.controller;


import com.coffee.app.spring.practice.coffee.dto.CoffeePatchDto;
import com.coffee.app.spring.practice.coffee.dto.CoffeePostDto;
import com.coffee.app.spring.practice.coffee.dto.CoffeeResponseDto;
import com.coffee.app.spring.practice.coffee.entity.Coffee;
import com.coffee.app.spring.practice.coffee.mapper.CoffeeMapper;
import com.coffee.app.spring.practice.coffee.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/v1/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;
    private final CoffeeMapper mapper;

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {
        Coffee coffee = mapper.coffeePostDtoToCoffee(coffeePostDto);
        Coffee response = coffeeService.createCoffee(coffee);

        return new ResponseEntity(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);

        Coffee coffee = mapper.coffeePatchDtoToCoffee(coffeePatchDto);
        Coffee response = coffeeService.updateCoffee(coffee);

        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") @Positive long coffeeId) {
        Coffee coffee = coffeeService.findCoffee(coffeeId);

        return new ResponseEntity(mapper.coffeeToCoffeeResponseDto(coffee), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        List<Coffee> coffees = coffeeService.findCoffees();
        List<CoffeeResponseDto> response = coffees.stream()
                .map(mapper::coffeeToCoffeeResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") @Positive long coffeeId) {
        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
