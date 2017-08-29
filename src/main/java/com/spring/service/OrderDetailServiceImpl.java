package com.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.OrderDetailDAO;
import com.spring.model.Orderdetail;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Override
	public void saveOrderDetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		orderDetailDAO.saveOrderDetail(orderdetail);
		
	}

	@Override
	public Set<Orderdetail> getOrderdetailListByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDetailDAO.getOrderdetailListByOrderId(orderId);
	}

	

	

	
	
}
