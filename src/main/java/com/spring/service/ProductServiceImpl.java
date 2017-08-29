package com.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	public List<Product> listProducts(){
		return this.productDAO.listProducts();
	}
	
	@Override
	public List<Product> getProductListByProductTypeId(int productTypeId){
		return this.productDAO.getProductListByProductTypeId(productTypeId);
	}
	
	@Override
	@Transactional
	public List<Product> getProductListByProductTypeName(String productTypeName){
		return this.productDAO.getProductListByProductTypeName(productTypeName);
	}
	
	@Override
	public List<Product> listProductsPaging(int pageNumber, int pageSize){
		return this.productDAO.listProductsPaging(pageNumber, pageSize);
	}

	@Override
	public long getNumberOfRecordsOfProduct() {
		// TODO Auto-generated method stub
		return this.productDAO.getNumberOfRecordsOfProduct();
	}

	@Override
	public Set<Product> getProductListByProductTypeId1(int productTypeId) {
		// TODO Auto-generated method stub
		return this.productDAO.getProductListByProductTypeId1(productTypeId);
	}

	@Override
	@Transactional
	public long getNumberOfProductByProductTypeId(int productTypeId) {
		// TODO Auto-generated method stub
		return this.productDAO.getNumberOfProductByProductTypeId(productTypeId);
	}

	@Override
	public int getNumberOfPagesByProductTypeIdandPageSize(int pageSize, int productTypeId) {
		// TODO Auto-generated method stub
		return this.productDAO.getNumberOfPagesByProductTypeIdandPageSize(pageSize, productTypeId);
	}

	@Override
	public List<Product> listProductsPagingByProductTypeId(int productTypeId, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return this.productDAO.listProductsPagingByProductTypeId(productTypeId, pageNumber, pageSize);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return this.productDAO.getProductById(id);
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productDAO.addProduct(product);
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		this.productDAO.deleteProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		this.productDAO.updateProduct(product);
		
	}

	@Override
	public List<Product> listProductsPagingByProductTypeIdAndSort(int productTypeId, int pageNumber, int pageSize,
			String sort) {
		// TODO Auto-generated method stub
		return this.productDAO.listProductsPagingByProductTypeIdAndSort(productTypeId, pageNumber, pageSize, sort);
	}

	@Override
	public void indexProducts() throws Exception {
		// TODO Auto-generated method stub
		this.productDAO.indexProducts();
	}

	@Override
	public List<Product> search(String keyword) {
		// TODO Auto-generated method stub
		return this.productDAO.search(keyword);
	}

	@Override
	public List<Product> searchPaging(String keyword, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return this.productDAO.searchPaging(keyword, pageNumber, pageSize);
	}

	@Override
	public List<Product> listProductsByLatest() {
		// TODO Auto-generated method stub
		return this.productDAO.listProductsByLatest();
	}
	
	
	
}
