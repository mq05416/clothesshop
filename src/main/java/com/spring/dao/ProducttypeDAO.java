package com.spring.dao;

import java.util.List;
import java.util.Set;

import com.spring.model.Product;
import com.spring.model.Producttype;

public interface ProducttypeDAO {
	public Producttype getProducttypeById(int id);
	public List<Producttype> listProductType();
	public Set<Producttype> getProducttypeListByAgesexId(int ageSexId);
	public Producttype addProducttype(Producttype producttype);
	public void deleteProducttypeById(int id);
	public void updateProducttype(Producttype producttype);
	public int convertNameToId(String name);
	
}
