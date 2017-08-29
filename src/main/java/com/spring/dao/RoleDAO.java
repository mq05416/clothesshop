package com.spring.dao;

import java.util.List;
import java.util.Set;

import com.spring.model.Product;
import com.spring.model.Role;
import com.spring.model.User;

public interface RoleDAO {
	public List<Role> listRoles();
	public Set<Role> getRolesByUsername(String username) ;

	
}
