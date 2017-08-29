package com.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProducttypeDAO;
import com.spring.model.Producttype;

@Service
@Transactional
public class ProducttypeServiceImpl implements ProducttypeService {
	
	
	@Autowired
	private ProducttypeDAO producttypeDAO;


	@Override
	public List<Producttype> listProductType(){
		return this.producttypeDAO.listProductType();
	}
	
	@Override
	public Producttype getProducttypeById(int id){
		return this.producttypeDAO.getProducttypeById(id);
	}

	@Override
	public Set<Producttype> getProducttypeListByAgesexId(int ageSexId) {
		// TODO Auto-generated method stub
		return this.producttypeDAO.getProducttypeListByAgesexId(ageSexId);
	}

	@Override
	public Producttype addProducttype(Producttype producttype) {
		// TODO Auto-generated method stub
		return producttypeDAO.addProducttype(producttype);
	}

	@Override
	public void deleteProducttypeById(int id) {
		// TODO Auto-generated method stub
		this.producttypeDAO.deleteProducttypeById(id);
		
	}

	@Override
	public void updateProducttype(Producttype producttype) {
		// TODO Auto-generated method stub
		this.producttypeDAO.updateProducttype(producttype);
		
	}

	@Override
	public int convertNameToId(String name) {
		// TODO Auto-generated method stub
		return this.producttypeDAO.convertNameToId(name);
	}

	
	
	
	
	
	
}
