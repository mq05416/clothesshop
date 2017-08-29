package com.spring.dao;

import java.util.List;
import java.util.Set;

import com.spring.model.Product;
import com.spring.model.Role;
import com.spring.model.User;

public interface UserDAO {
	public void saveUser(User user);

	public boolean checkUser(User user) ;
	public User getUser(String  username) ;
	public void saveUserWithRoles(User user, Set<Role> roles);
	public User getUserByEmail(String  email) ;
	public void updateUser(User user);
	
}
