package com.spring.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.model.Producttype;
import com.spring.modelVO.ProducttypeVO;
import com.spring.service.ProductService;
import com.spring.service.ProducttypeService;

@Component
public class HelperImpl {
	@Autowired
	private ProducttypeService producttypeService;
	@Autowired
	private ProductService productService;

	/* Tinh so san pham cua loai tuong ung producttypeid */

	public long getNumberOfProduct(int productTypeId) {

		return this.productService.getNumberOfProductByProductTypeId(productTypeId);
	}

	public List<ProducttypeVO> calculateQuantityOfEachType() {

		List<ProducttypeVO> producttypeVOs = new ArrayList<>();

		List<Producttype> producttypes = producttypeService.listProductType();
		/* System.out.println(producttypes); */
		for (Producttype producttype : producttypes) {
			ProducttypeVO producttypeVO = new ProducttypeVO();
			System.out.println("Product Types:\n " + producttype.getId() + "===" + producttype.getName());
			producttypeVO.setProducttypeId(producttype.getId());
			producttypeVO.setProducttypeName(producttype.getName());
			producttypeVO.setProductNumberOfType(productService.getNumberOfProductByProductTypeId(producttype.getId()));
			producttypeVOs.add(producttypeVO);
			System.out.println("Steps: " + producttypeVOs);
		}
		return producttypeVOs;
	}
}
