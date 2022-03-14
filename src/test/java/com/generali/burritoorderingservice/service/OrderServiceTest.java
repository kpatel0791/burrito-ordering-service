package com.generali.burritoorderingservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.generali.burritoorderingservice.model.Order;
import com.generali.burritoorderingservice.model.OrderItems;
import com.generali.burritoorderingservice.repository.CustomOrderRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class OrderServiceTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Autowired
	private CustomOrderRepository customOrderRepository;

	@Autowired
	private OrderService orderService;

	@Test
	void saveOrder_test() {

		OrderItems tortilla = new OrderItems();
		tortilla.setType("Tortilla");
		tortilla.setItems(new ArrayList<String>(Arrays.asList("corn")));

		OrderItems salsa = new OrderItems();
		salsa.setType("Salsa");
		salsa.setItems(new ArrayList<String>(Arrays.asList("mild")));

		List<OrderItems> ordeItems = new ArrayList<OrderItems>();
		ordeItems.add(tortilla);
		ordeItems.add(salsa);

		Order order = new Order();
		order.setOrderNames(ordeItems);

		order = customOrderRepository.save(order);

		assertNotNull(customOrderRepository.findByOrderId(order.getId()));
		System.out.println(order);
	}

}
