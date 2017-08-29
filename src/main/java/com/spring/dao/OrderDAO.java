package com.spring.dao;

import java.util.List;

import com.spring.model.Order;
import com.spring.model.Product;
import com.spring.model.Producttype;

public interface OrderDAO {
	

	public void saveOrder(Order order);
	public List<Order> listOrders();
	public Order getOrderByOrderId(int orderId);
	public void updateOrder(Order order);
	
	
	
	
}
