package com.spring.service;

import java.util.Set;

import com.spring.model.Role;
import com.spring.model.User;

public interface UserService {
	public void saveUser(User user);
	public boolean checkUser(User user) ;
	public void saveUserWithRoles(User user, Set<Role> roles);
	public User getUser(String  username) ;
	public User getUserByEmail(String  email) ;
	public void updateUser(User user);
	
}
