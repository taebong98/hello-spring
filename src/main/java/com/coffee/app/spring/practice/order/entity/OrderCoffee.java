package com.coffee.app.spring.practice.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.coffee.app.spring.practice.coffee.entity.Coffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderCoffee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderCoffeeId;

	private int quantity;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "coffee_id")
	private Coffee coffee;
}
