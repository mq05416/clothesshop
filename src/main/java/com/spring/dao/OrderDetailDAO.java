package com.spring.dao;

import java.util.Set;

import com.spring.model.Orderdetail;

public interface OrderDetailDAO {
	

	public void saveOrderDetail(Orderdetail orderdetail);
	public Set<Orderdetail> getOrderdetailListByOrderId(int orderId);
	
	
	
	
}
