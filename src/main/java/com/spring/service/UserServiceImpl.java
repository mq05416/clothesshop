package com.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDAO;
import com.spring.model.Role;
import com.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveUser(user);
		
	}

	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(user);
	}

	@Override
	public void saveUserWithRoles(User user, Set<Role> roles) {
		// TODO Auto-generated method stub
		userDAO.saveUserWithRoles(user, roles);
		
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUser(username);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.getUserByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.updateUser(user);
	}

	
	

	
	
	
	
}
