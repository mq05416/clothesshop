package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.FeedbackDAO;
import com.spring.model.Feedback;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackDAO feedbackDAO;

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackDAO.addFeedback(feedback);
	}

	@Override
	public List<Feedback> listFeedbacks() {
		// TODO Auto-generated method stub
		return feedbackDAO.listFeedbacks();
	}

	@Override
	public Feedback getFeedbackById(int id) {
		// TODO Auto-generated method stub
		return feedbackDAO.getFeedbackById(id);
	}

	@Override
	public void deleteFeedbackById(int id) {
		// TODO Auto-generated method stub
		feedbackDAO.deleteFeedbackById(id);
	}

	

	
}
