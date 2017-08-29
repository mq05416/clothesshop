package com.spring.service;

import java.util.List;
import java.util.Set;

import com.spring.model.Product;
import com.spring.model.Role;

public interface RoleService {
	public List<Role> listRoles();
	public Set<Role> getRolesByUsername(String username) ;
	
}
