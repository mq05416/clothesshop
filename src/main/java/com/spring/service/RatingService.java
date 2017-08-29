package com.spring.service;

import java.util.List;
import java.util.Set;

import com.spring.model.Agesex;
import com.spring.model.Product;
import com.spring.model.Rating;

public interface RatingService {
	public void addRating(Rating rating);
	public List<Rating> getRatingListByProductId(int productId);
}
