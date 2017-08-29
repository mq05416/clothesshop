package com.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.OrderDAO;
import com.spring.dao.ProductDAO;
import com.spring.model.Order;
import com.spring.model.Product;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		orderDAO.saveOrder(order);
	}

	@Override
	public List<Order> listOrders() {
		// TODO Auto-generated method stub
		return orderDAO.listOrders();
	}

	@Override
	public Order getOrderByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderByOrderId(orderId);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		orderDAO.updateOrder(order);
	}

	

	
	
}
