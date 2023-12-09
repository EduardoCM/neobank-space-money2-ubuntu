package com.neobank.spacemoney.service.impl;

import com.neobank.spacemoney.orders.Order;
import com.neobank.spacemoney.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public void saveOrder(Order order) {
		order.getResponse().persist();
	}

}
