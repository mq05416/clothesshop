package com.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.AgesexDAO;
import com.spring.dao.ProductDAO;
import com.spring.model.Agesex;
import com.spring.model.Product;

@Service
@Transactional
public class AgesexServiceImpl implements AgesexService {
	
	@Autowired
	private AgesexDAO agesexDAO;

	

	



	@Override
	public List<Agesex> listAgeSex() {
		// TODO Auto-generated method stub
		return agesexDAO.listAgeSex();
	}







	@Override
	public Agesex getAgesexById(int id) {
		// TODO Auto-generated method stub
		return agesexDAO.getAgesexById(id);
	}







	@Override
	public int convertNameToId(String name) {
		// TODO Auto-generated method stub
		return agesexDAO.convertNameToId(name);
	}
	
	
	
	
	
}
