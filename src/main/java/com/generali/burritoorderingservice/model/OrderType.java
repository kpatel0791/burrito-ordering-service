package com.generali.burritoorderingservice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderType {

	private String name;

	private List<OrderItems> oItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrderItems> getoItems() {

		oItems = new ArrayList<OrderItems>();
		OrderItems torTillaItem = new OrderItems();
		torTillaItem.setType("Tortilla");
		torTillaItem.setItems(new ArrayList<String>(Arrays.asList("corn", "flour")));
		torTillaItem.setLimit(1);
		oItems.add(torTillaItem);

		OrderItems proteinItem = new OrderItems();
		proteinItem.setType("Protein");
		proteinItem.setItems(new ArrayList<String>(Arrays.asList("bean", "beef", "chicken", "pork", "shrimp", "steak")));
		proteinItem.setLimit(1);
		oItems.add(proteinItem);

		OrderItems vegetablesItem = new OrderItems();
		vegetablesItem.setType("Vegetables");
		vegetablesItem.setItems(new ArrayList<String>(Arrays.asList("cabbage", "corn", "jalapenos")));
		oItems.add(vegetablesItem);

		OrderItems salsaItem = new OrderItems();
		salsaItem.setType("Salsa");
		salsaItem.setItems(new ArrayList<String>(Arrays.asList("mild", "medium", "hot")));
		salsaItem.setLimit(1);
		oItems.add(salsaItem);

		OrderItems extrasItem = new OrderItems();
		extrasItem.setType("Extras");
		extrasItem.setItems(new ArrayList<String>(Arrays.asList("avocado")));
		oItems.add(extrasItem);
		return oItems;
	}

	public void setoItems(List<OrderItems> oItems) {
		this.oItems = oItems;
	}

	public OrderItems getOrderType(String type) {

		for (OrderItems item : getoItems()) {
			if (type.equalsIgnoreCase(item.getType())) {
				return item;
			}
		}

		return null;
	}

}
