package com.spring.service;

import java.util.List;
import java.util.Set;

import com.spring.model.Product;

public interface ProductService {
	public List<Product> listProducts();
	public List<Product> getProductListByProductTypeId(int productTypeId);
	public List<Product> getProductListByProductTypeName(String productTypeName);
	public List<Product> listProductsPaging(int pageNumber, int pageSize);
	public long getNumberOfRecordsOfProduct();
	public Set<Product> getProductListByProductTypeId1(int productTypeId);
	public long getNumberOfProductByProductTypeId(int productTypeId);
	public int getNumberOfPagesByProductTypeIdandPageSize(int pageSize, int productTypeId);
	public List<Product> listProductsPagingByProductTypeId(int productTypeId, int pageNumber, int pageSize) ;
	public Product getProductById(int id);
	public Product addProduct(Product product);
	public void deleteProductById(int id);
	public void updateProduct(Product product);
	public List<Product> listProductsPagingByProductTypeIdAndSort(int productTypeId, int pageNumber, int pageSize, String sort);
	public void indexProducts() throws Exception;
	public List<Product> search(String keyword);
	public List<Product> searchPaging(String keyword, int pageNumber, int pageSize);
	public List<Product> listProductsByLatest();
}
