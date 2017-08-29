package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Order;
import com.spring.model.Producttype;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(order);
	}



	@Override
	public List<Order> listOrders() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orders = session.createQuery("from Order").list();
		return orders;
	}



	@Override
	public Order getOrderByOrderId(int orderId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, new Integer(orderId));

		return order;
	}



	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(order);
		
	}

	
}
