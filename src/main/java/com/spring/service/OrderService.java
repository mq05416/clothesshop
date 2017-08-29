package com.spring.service;

import java.util.List;
import java.util.Set;

import com.spring.model.Order;
import com.spring.model.Product;

public interface OrderService {
	public void saveOrder(Order order);
	public List<Order> listOrders();
	public Order getOrderByOrderId(int orderId);
	public void updateOrder(Order order);
}
