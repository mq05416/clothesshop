package com.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;
import com.spring.dao.RoleDAO;
import com.spring.model.Product;
import com.spring.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public List<Role> listRoles() {
		// TODO Auto-generated method stub
		return roleDAO.listRoles();
	}

	@Override
	public Set<Role> getRolesByUsername(String username) {
		// TODO Auto-generated method stub
		return roleDAO.getRolesByUsername(username);
	}

	

	
	
	
	
	
}
