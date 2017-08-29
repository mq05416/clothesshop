package com.spring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.model.Agesex;
import com.spring.model.Product;
import com.spring.model.Producttype;

@Repository
public class AgesexDAOImpl implements AgesexDAO {

	private static final Logger logger = LoggerFactory.getLogger(AgesexDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProducttypeDAO producttypeDAO;
	
	
	
	
	


	/*Liet ke tat ca cac san pham*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Agesex> listAgeSex() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Agesex> agesexs = session.createQuery("from Agesex").list();
		return agesexs;
	}







	@Override
	public Agesex getAgesexById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Agesex agesex = (Agesex) session.get(Agesex.class, new Integer(id));
		return agesex;
	}
	
	
	@Override
	public int convertNameToId(String name) {
		// TODO Auto-generated method stub
		List<Agesex> agesexs = listAgeSex();
		
		for (Agesex agesex : agesexs) {
			if (agesex.getName().equalsIgnoreCase(name)) return agesex.getId();
			
		}
		return 0;
	}
	
}
