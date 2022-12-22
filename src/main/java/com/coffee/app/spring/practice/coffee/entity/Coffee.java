package com.coffee.app.spring.practice.coffee.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.coffee.app.spring.practice.order.entity.OrderCoffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Coffee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long coffeeId;

	@Column(length = 100, nullable = false)
	private String korName;

	@Column(length = 100, nullable = false)
	private String engName;

	@Column(nullable = false)
	private Integer price;

	@Column(length = 3, nullable = false, unique = true)
	private String coffeeCode;

	@Enumerated(value = EnumType.STRING)
	@Column(length = 20, nullable = false)
	private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false, name = "LAST_MODIFIED_AT")
	private LocalDateTime modifiedAt = LocalDateTime.now();

	@OneToMany(mappedBy = "coffee")
	private List<OrderCoffee> orderCoffees = new ArrayList<>();
	
	public enum CoffeeStatus {
		COFFEE_FOR_SALE("판매중"),
		COFFEE_SOLD_OUT("판매중지");

		@Getter
		public String status;

		CoffeeStatus(String status) {
			this.status = status;
		}
	}
}
