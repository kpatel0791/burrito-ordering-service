package com.generali.burritoorderingservice.model;

import java.util.List;

public class OrderItems {
	private String type;

	private List<String> items;

	private int limit;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public OrderItems() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderItems [type=" + type + ", items=" + items + "]";
	}

}
