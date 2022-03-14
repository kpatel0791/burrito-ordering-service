package com.generali.burritoorderingservice.repository;

import com.generali.burritoorderingservice.model.Order;

public interface InOrderRepository {
	
	public Order findByOrderId(long orderId);
	
	public  Order save(Order order);
	
		

}
