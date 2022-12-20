package com.coffee.app.spring.practice.coffee.repository;

import com.coffee.app.spring.practice.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

    @Query("SELECT c FROM Coffee c WHERE c.coffeeId =:coffeeId")
    Optional<Coffee> findByCoffeeId(long coffeeId);
}
