package com.spring.service;

import java.util.List;
import java.util.Set;

import com.spring.model.Order;
import com.spring.model.Orderdetail;
import com.spring.model.Product;

public interface OrderDetailService {
	public void saveOrderDetail(Orderdetail orderdetail);
	public Set<Orderdetail> getOrderdetailListByOrderId(int orderId);
}
