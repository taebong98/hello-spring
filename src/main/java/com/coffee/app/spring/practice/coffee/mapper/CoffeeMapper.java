package com.coffee.app.spring.practice.coffee.mapper;

import com.coffee.app.spring.practice.coffee.dto.CoffeePatchDto;
import com.coffee.app.spring.practice.coffee.dto.CoffeePostDto;
import com.coffee.app.spring.practice.coffee.dto.CoffeeResponseDto;
import com.coffee.app.spring.practice.coffee.entity.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
}
