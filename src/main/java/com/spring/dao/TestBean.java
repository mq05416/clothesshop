package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.service.ProductService;

@Component
public class TestBean {
	
	@Autowired
	private ProductService productService;
	

	public String testBean() {
		return "Hello " + productService.listProducts().toString();
	}
}
