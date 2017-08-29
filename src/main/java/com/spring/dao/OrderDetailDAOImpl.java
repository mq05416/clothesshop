package com.spring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Order;
import com.spring.model.Orderdetail;
import com.spring.model.Product;
import com.spring.model.Producttype;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderDetailDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void saveOrderDetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(orderdetail);

	}

	@Override
	public Set<Orderdetail> getOrderdetailListByOrderId(int orderId) {
		// TODO Auto-generated method stub
		Order order = this.orderDAO.getOrderByOrderId(orderId);
		Set<Orderdetail> orderdetails = order.getOrderdetails();
		return orderdetails;
		
	}

	

}
