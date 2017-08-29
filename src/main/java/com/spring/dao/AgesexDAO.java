package com.spring.dao;

import java.util.List;
import java.util.Set;

import com.spring.model.Agesex;
import com.spring.model.Product;
import com.spring.model.Producttype;

public interface AgesexDAO {
	public List<Agesex> listAgeSex();
	public Agesex getAgesexById(int id);

	public int convertNameToId(String name);
}
