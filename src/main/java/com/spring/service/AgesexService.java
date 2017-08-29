package com.spring.service;

import java.util.List;
import java.util.Set;

import com.spring.model.Agesex;
import com.spring.model.Product;

public interface AgesexService {
	public List<Agesex> listAgeSex();
	public Agesex getAgesexById(int id);
	public int convertNameToId(String name);
}
