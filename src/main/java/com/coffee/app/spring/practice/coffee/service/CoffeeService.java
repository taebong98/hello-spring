package com.coffee.app.spring.practice.coffee.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.app.spring.practice.coffee.entity.Coffee;
import com.coffee.app.spring.practice.coffee.repository.CoffeeRepository;
import com.coffee.app.spring.practice.exception.BusinessLogicException;
import com.coffee.app.spring.practice.exception.ExceptionCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CoffeeService {

	private final CoffeeRepository coffeeRepository;

	public Coffee createCoffee(Coffee coffee) {
		String coffeeCode = coffee.getCoffeeCode().toUpperCase();
		verifyExistsCoffee(coffeeCode);

		return coffeeRepository.save(coffee);
	}

	public Coffee updateCoffee(Coffee coffee) {
		// TODO should business logic
		Coffee findCoffee = findCoffee(coffee.getCoffeeId());

		Optional.ofNullable(coffee.getKorName())
			.ifPresent(korName -> findCoffee.setKorName(korName));
		Optional.ofNullable(coffee.getEngName())
			.ifPresent(engName -> findCoffee.setEngName(engName));
		Optional.ofNullable(coffee.getPrice())
			.ifPresent(price -> findCoffee.setPrice(price));
		Optional.ofNullable(coffee.getCoffeeStatus())
			.ifPresent(coffeeStatus -> findCoffee.setCoffeeStatus(coffeeStatus));

		return coffeeRepository.save(findCoffee);
	}

	@Transactional(readOnly = true)
	public Coffee findCoffee(long coffeeId) {
		Optional<Coffee> coffee = coffeeRepository.findByCoffeeId(coffeeId);
		Coffee findCoffee = coffee.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));
		return findCoffee;
	}

	@Transactional(readOnly = true)
	public Page<Coffee> findCoffees(int page, int size) {
		Page<Coffee> pageCoffee = coffeeRepository.findAll(
			PageRequest.of(page, size, Sort.by("coffeeId").descending()));

		return pageCoffee;
	}

	public void deleteCoffee(long coffeeId) {
		Coffee coffee = findCoffee(coffeeId);
		coffeeRepository.delete(coffee);
	}

	public Coffee findVerifiedCoffee(long coffeeId) {
		Optional<Coffee> optionalCoffee = coffeeRepository.findById(coffeeId);
		Coffee findCoffee =
			optionalCoffee.orElseThrow(() ->
				new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

		return findCoffee;
	}

	private void verifyExistsCoffee(String coffeeCode) {
		Optional<Coffee> findCoffee = coffeeRepository.findByCoffeeCode(coffeeCode);
		if (findCoffee.isPresent())
			throw new BusinessLogicException(ExceptionCode.COFFEE_EXISTS);
	}
}
