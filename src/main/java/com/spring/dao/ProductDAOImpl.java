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

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProducttypeDAO producttypeDAO;

	/* Liet ke tat ca cac san pham */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product").list();

		return products;
	}

	/* Lay san pham ra bang Id */
	@Override
	public Product getProductById(int id) {
		Session session = null;
		Product product = new Product();
		try {
			session = this.sessionFactory.getCurrentSession();
			product = (Product) session.get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	/* Tinh so record cua table Product */
	@Override
	public long getNumberOfRecordsOfProduct() {
		Session session = this.sessionFactory.getCurrentSession();

		return (Long) session.createCriteria(Product.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	/* Liet ke cac product tuy vao loai producttypeid */
	@Override
	public List<Product> getProductListByProductTypeId(int productTypeId) {
		Session session = this.sessionFactory.getCurrentSession();
		SQLQuery qry = session.createSQLQuery(
				"SELECT * FROM test111est111.product p1 INNER JOIN test111est111.producttype p2 ON p1.Id_ProductType = p2.Id WHERE p2.Id = '"
						+ productTypeId + "'")
				.addEntity(Product.class);
		List<Product> products = qry.list();
		return products;

	}

	/* Liet ke cac product tuy vao loai producttypeid version 2 */
	@Override
	public Set<Product> getProductListByProductTypeId1(int productTypeId) {

		Producttype producttype = this.producttypeDAO.getProducttypeById(productTypeId);
		Set<Product> products = producttype.getProducts();
		return products;

	}

	/* Tinh so san pham cua loai tuong ung producttypeid */
	@Override
	public long getNumberOfProductByProductTypeId(int productTypeId) {

		return getProductListByProductTypeId(productTypeId).size();
	}

	@Override
	public List<Product> getProductListByProductTypeName(String productTypeName) {

		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * session.beginTransaction(); String select =
		 * "select p FROM Product p INNER JOIN p.producttype"; Query query =
		 * session.createQuery(select); List<Product> productList =
		 * query.list(); session.getTransaction().commit(); session.close();
		 * return productList;
		 */

		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * SQLQuery qry =
		 * session.createSQLQuery("select * from test111.product").
		 * addEntity(Product.class); List<Product> products = qry.list(); return
		 * products;
		 */

		Session session = this.sessionFactory.getCurrentSession();
		SQLQuery qry = session.createSQLQuery(
				"SELECT * FROM test111.product p1 INNER JOIN test111.producttype p2 ON p1.Id_ProductType = p2.Id WHERE p2.Name = '"
						+ productTypeName + "'")
				.addEntity(Product.class);
		List<Product> products = qry.list();
		return products;

	}

	/* Tinh so trang hien thi cho moi loai san pham va kich co tren 1 trang */
	@Override
	public int getNumberOfPagesByProductTypeIdandPageSize(int pageSize, int productTypeId) {
		long numberOfPages;
		long numberOfRecords = getNumberOfProductByProductTypeId(productTypeId);
		if ((numberOfRecords % pageSize) != 0)
			numberOfPages = (numberOfRecords / pageSize) + 1;
		else
			numberOfPages = numberOfRecords / pageSize;
		return (int) numberOfPages;
	}

	/*
	 * Tinh so trang hien thi (cho tat ca cac san pham) tuy vao kich co tren 1
	 * trang
	 */
	/*
	 * public int getNumberOfPages(int pageSize) { // ko phu thuoc so ID long
	 * numberOfPages; long numberOfRecords = getNumberOfRecordsOfProduct(); if
	 * ((numberOfRecords % pageSize) != 0) numberOfPages = (numberOfRecords /
	 * pageSize) + 1; else numberOfPages = numberOfRecords / pageSize; return
	 * (int) numberOfPages;
	 * 
	 * }
	 */

	/*
	 * Phan trang cho tat ca cac san pham (ko phan biet loai) tuy vao trang so
	 * may va kich co tren 1 trang
	 */
	@Override
	public List<Product> listProductsPaging(int pageNumber, int pageSize) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT p from Product p");

		query.setFirstResult((pageNumber - 1) * pageSize); // ko lien quan so
															// ID, va dem tu 0
															// (mac dinh),
															// pageNumber >=1
		query.setMaxResults(pageSize);
		List<Product> productList = query.list();
		return productList;
	}

	/*
	 * Phan trang cho cac san pham thuoc loai producttypeid va tuy vao kich co
	 * tren 1 trang va vi tri cua trang
	 */
	@Override
	public List<Product> listProductsPagingByProductTypeId(int productTypeId, int pageNumber, int pageSize) {

		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Product p WHERE p.producttype.id = '" + productTypeId + "'");

		query.setFirstResult((pageNumber - 1) * pageSize); // ko lien quan so
															// ID, va dem tu 0
															// (mac dinh),
															// pageNumber >=1
		query.setMaxResults(pageSize);
		List<Product> productList = query.list();
		return productList;
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		return product;
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Product product = (Product) session.get(Product.class, new Integer(id));
		session.delete(product);

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(product);

	}

	@Override
	public List<Product> listProductsPagingByProductTypeIdAndSort(int productTypeId, int pageNumber, int pageSize,
			String sort) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = null;
		if (sort.equalsIgnoreCase("latest")) {
			System.out.println("Dao Sort: " + sort);
			query = session.createQuery("FROM Product p WHERE p.producttype.id = '" + productTypeId + "'"
					+ "order by date(createdDate) desc");
		} else if (sort.equalsIgnoreCase("price")) {
			System.out.println("Dao Sort: " + sort);
			query = session.createQuery(
					"FROM Product p WHERE p.producttype.id = '" + productTypeId + "'" + "order by price ASC");
		} else {
			System.out.println("Dao Sort: " + sort);
			query = session.createQuery("FROM Product p WHERE p.producttype.id = '" + productTypeId + "'");
		}

		query.setFirstResult((pageNumber - 1) * pageSize); // ko lien quan so
															// ID, va dem tu 0
															// (mac dinh),
															// pageNumber >=1
		query.setMaxResults(pageSize);
		List<Product> productList = query.list();
		return productList;
	}

	@Override
	public void indexProducts() throws Exception {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Product> search(String keyword) {
		Session session = this.sessionFactory.getCurrentSession();

		FullTextSession fullTextSession = Search.getFullTextSession(session);

		QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query query = qb.keyword().onFields("name").matching(keyword).createQuery();

		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Product.class);

		List<Product> results = hibQuery.list();
		return results;
	}

	@Override
	public List<Product> searchPaging(String keyword, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		FullTextSession fullTextSession = Search.getFullTextSession(session);

		QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		org.apache.lucene.search.Query query = qb.keyword().onFields("name").matching(keyword).createQuery();

		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Product.class);
		hibQuery.setFirstResult((pageNumber - 1) * pageSize); // ko lien quan so
		// ID, va dem tu 0
		// (mac dinh),
		// pageNumber >=1
		hibQuery.setMaxResults(pageSize);

		List<Product> results = hibQuery.list();
		return results;
	}

	@Override
	public List<Product> listProductsByLatest() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = null;

		query = session.createQuery("FROM Product p order by date(createdDate) desc");

		query.setFirstResult(0); // ko lien quan so
															// ID, va dem tu 0
															// (mac dinh),
															// pageNumber >=1
		query.setMaxResults(3);
		List<Product> productList = query.list();
		return productList;
	}
}
