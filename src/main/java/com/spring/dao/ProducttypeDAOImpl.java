package com.spring.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Agesex;
import com.spring.model.Product;
import com.spring.model.Producttype;

@Repository
public class ProducttypeDAOImpl implements ProducttypeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private AgesexDAO agesexDAO;

	@Override
	public Producttype getProducttypeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Producttype producttype = (Producttype) session.get(Producttype.class, new Integer(id));

		return producttype;
	}

	/* Liet ke cac producttype */
	@Override
	public List<Producttype> listProductType() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Producttype> producttypes = session.createQuery("from Producttype").list();

		return producttypes;
	}

	@Override
	public Set<Producttype> getProducttypeListByAgesexId(int ageSexId) {
		// TODO Auto-generated method stub
		Agesex agesex = this.agesexDAO.getAgesexById(ageSexId);
		Set<Producttype> producttypes = agesex.getProducttypes();

		return producttypes;
	}

	@Override
	public Producttype addProducttype(Producttype producttype) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(producttype);
		return producttype;
	}

	@Override
	public void deleteProducttypeById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Producttype producttype = (Producttype) session.get(Producttype.class, new Integer(id));
		session.delete(producttype);

	}

	@Override
	public void updateProducttype(Producttype producttype) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(producttype);

	}

	@Override
	public int convertNameToId(String name) {
		// TODO Auto-generated method stub
		List<Producttype> producttypes = listProductType();

		for (Producttype producttype : producttypes) {
			if (producttype.getName().equalsIgnoreCase(name))
				return producttype.getId();

		}
		return 0;
	}

}
