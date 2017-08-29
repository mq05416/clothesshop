package com.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.AgesexDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.RatingDAO;
import com.spring.model.Agesex;
import com.spring.model.Product;
import com.spring.model.Rating;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingDAO ratingDAO;

	@Override
	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		ratingDAO.addRating(rating);
	}

	@Override
	public List<Rating> getRatingListByProductId(int productId) {
		// TODO Auto-generated method stub
		return ratingDAO.getRatingListByProductId(productId);
	}

	

	



	






	
	
	
	
}
