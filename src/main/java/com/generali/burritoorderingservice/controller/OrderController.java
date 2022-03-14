package com.generali.burritoorderingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generali.burritoorderingservice.model.Order;
import com.generali.burritoorderingservice.service.OrderService;

@RestController
@RequestMapping("api/v1")

public class OrderController {
	
		
	 private final OrderService orderService;

	    public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }
	    
	    @PostMapping("orders")
	    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
	    	Order saveProduct = orderService.addOrder(order);
	        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
	    }
	    @GetMapping("/orders/{id}")
		public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {

			Order order = orderService.getOrderByid(id);
			if (order != null) {
				return new ResponseEntity<>(order, HttpStatus.OK);
			}
			return new ResponseEntity<>("No order found for given order id.", HttpStatus.NOT_FOUND);
		}
		
}
