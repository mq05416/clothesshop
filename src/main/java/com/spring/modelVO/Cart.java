package com.spring.modelVO;

import com.spring.model.Product;

public class Cart implements java.io.Serializable{
	private Product product;
	private int quantity;
	public Cart() {
		super();
	}
	public Cart(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [product=" + product + ", quantity=" + quantity + "]\n";
	}

	
}
