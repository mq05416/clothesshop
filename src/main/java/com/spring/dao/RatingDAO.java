package com.spring.dao;

import java.util.List;
import java.util.Set;

import com.spring.model.Product;
import com.spring.model.Producttype;
import com.spring.model.Rating;

public interface RatingDAO {
	

	public void addRating(Rating rating);
	public List<Rating> getRatingListByProductId(int productId);
	
	
	
	
}
