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

import com.spring.model.Product;
import com.spring.model.Producttype;
import com.spring.model.Role;
import com.spring.model.User;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProducttypeDAO producttypeDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<Role> listRoles() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Role> roles = session.createQuery("from Role").list();
		
		return roles;
	}

	@Override
	public Set<Role> getRolesByUsername(String username) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Set<Role> roles = userDAO.getUser(username).getRoles();
		return roles;
	}
	
	
	
	
	
	
	
}
