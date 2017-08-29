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
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);

	}
	@Override
	public void saveUserWithRoles(User user, Set<Role> roles){
		Session session = this.sessionFactory.getCurrentSession();
		user.setRoles(roles);
		session.persist(user);
		
	}
	
	@Override
	public boolean checkUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from User where username=?");

		User user1 = (User) query.setString(0, user.getUsername()).uniqueResult();
		if (user1 != null) {
			// Do whatever you want to do
			return true;
		} else {
			// Insert user
			return false;
		}

	}
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from User where username=?");

		User user1 = (User) query.setString(0, username).uniqueResult();
		return user1;
	}
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from User where email=?");

		User user1 = (User) query.setString(0, email).uniqueResult();
		return user1;
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(user);
		
	}

}
