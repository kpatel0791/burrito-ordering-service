package com.generali.burritoorderingservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.generali.burritoorderingservice.model.Order;

@Repository
public class CustomOrderRepository implements InOrderRepository {

	List<Order> orders = new ArrayList<>();
	Random random = new Random();
	int max= 1000;
	int min = 1;

	public CustomOrderRepository() {

	}

	@Override
	public Order findByOrderId(long orderId) {
		for (Order o : orders) {
			if (o.getId() == orderId) {
				return o;
			}
		}

		return null;
	}

	@Override
	public Order save(Order order) {
		long nextLong = random.nextLong((max - min) + 1) + min;
		order.setId(nextLong);
		orders.add(order);
		return order;
	}

}
