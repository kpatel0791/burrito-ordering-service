package com.generali.burritoorderingservice.service;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.stereotype.Service;

import com.generali.burritoorderingservice.model.Order;
import com.generali.burritoorderingservice.model.OrderItems;
import com.generali.burritoorderingservice.model.OrderType;
import com.generali.burritoorderingservice.repository.CustomOrderRepository;

@Service
public class OrderService {

	@Autowired
	private CustomOrderRepository customOrderRepository;

	public Order addOrder(Order order) {

		String message = getMessage(order);
		if (!message.isEmpty()) {
			order = new Order();
			order.setMessage(message);
			return order;
		}

		Order o = customOrderRepository.save(order);
		o.setMessage("Order created successfully.");
		return o;

	}

	public Order getOrderByid(Long id) {
		// TODO Auto-generated method stub
		Order orderObjById = customOrderRepository.findByOrderId(id);
		return orderObjById;
	}

	public String getMessage(Order order) {

		OrderType types = new OrderType();
		for (OrderItems oItem : order.getOrderNames()) {
			OrderItems orderType = types.getOrderType(oItem.getType());
			if ((orderType.getLimit() != 0 && oItem.getItems().size() != orderType.getLimit())) {
				return orderType.getType() + " not allowed to taken more than " + orderType.getLimit();
			}
		}

		return "";

	}
}
