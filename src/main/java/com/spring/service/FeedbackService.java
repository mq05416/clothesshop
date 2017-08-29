package com.spring.service;

import java.util.List;

import com.spring.model.Feedback;

public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback);
	public List<Feedback> listFeedbacks();
	public Feedback getFeedbackById(int id);
	public void deleteFeedbackById(int id);
}
