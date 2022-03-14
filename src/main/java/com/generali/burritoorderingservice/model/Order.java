package com.generali.burritoorderingservice.model;

import java.util.List;

public class Order {

	private long id;
	private List<OrderItems> orderNames;
	private String message;

	public Order() {
	}

	public Order(Long orderId, List<OrderItems> orderNames) {
		this.id = orderId;
		this.orderNames = orderNames;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public List<OrderItems> getOrderNames() {
		return orderNames;
	}

	public void setOrderNames(List<OrderItems> orderNames) {
		this.orderNames = orderNames;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNames=" + orderNames + "]";
	}

}
