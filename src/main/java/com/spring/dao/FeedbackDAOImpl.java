package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Feedback;
import com.spring.model.Product;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	private static final Logger logger = LoggerFactory.getLogger(FeedbackDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	
	


	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(feedback);
		return feedback;
	}





	@Override
	public List<Feedback> listFeedbacks() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Feedback> feedbacks = session.createQuery("from Feedback").list();

		return feedbacks;
	}





	@Override
	public Feedback getFeedbackById(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Feedback feedback = new Feedback();
		try {
			session = this.sessionFactory.getCurrentSession();
			feedback = (Feedback) session.get(Feedback.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feedback;
	}





	@Override
	public void deleteFeedbackById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = this.sessionFactory.getCurrentSession();

				Feedback feedback = (Feedback) session.get(Feedback.class, new Integer(id));
				session.delete(feedback);
	}

	
}
