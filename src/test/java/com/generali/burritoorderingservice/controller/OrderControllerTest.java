package com.generali.burritoorderingservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generali.burritoorderingservice.model.Order;
import com.generali.burritoorderingservice.model.OrderItems;
import com.generali.burritoorderingservice.model.OrderType;
import com.generali.burritoorderingservice.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
	@Mock
	private OrderService orderService;
	private Order order;
	private OrderType orderType;
	List<OrderItems> oItems;
	@InjectMocks
	private OrderController orderController;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		order = new Order(1L, orderType.getoItems());
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@Test
	public void PostMappingOfProduct() throws Exception {
		when(orderService.addOrder(any())).thenReturn(order);
		mockMvc.perform(post("/api/v1/orders").contentType(MediaType.APPLICATION_JSON).content(asJsonString(order)))
				.andExpect(status().isCreated());
		verify(orderService, times(1)).addOrder(order);
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
