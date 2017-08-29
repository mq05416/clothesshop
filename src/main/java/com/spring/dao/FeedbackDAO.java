package com.spring.dao;

import java.util.List;

import com.spring.model.Feedback;
import com.spring.model.Product;

public interface FeedbackDAO {
	

	public Feedback addFeedback(Feedback feedback);
	public List<Feedback> listFeedbacks();
	public Feedback getFeedbackById(int id);
	public void deleteFeedbackById(int id);
	
	
	
	
	
}
