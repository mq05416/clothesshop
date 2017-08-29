package com.spring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.model.Product;
import com.spring.model.Producttype;
import com.spring.model.Rating;

@Repository
public class RatingDAOImpl implements RatingDAO {

	private static final Logger logger = LoggerFactory.getLogger(RatingDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProducttypeDAO producttypeDAO;

	@Override
	public void addRating(Rating rating) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(rating);
	}

	@Override
	public List<Rating> getRatingListByProductId(int productId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Rating r WHERE r.productId = '" + productId + "'");

		
		List<Rating> ratingList = query.list();
		return ratingList;
	}

	
}
