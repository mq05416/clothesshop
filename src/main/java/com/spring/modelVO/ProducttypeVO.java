package com.spring.modelVO;

public class ProducttypeVO {
	private int producttypeId;
	private String producttypeName;
	private long productNumberOfType;

	public ProducttypeVO() {
		super();
	}

	public ProducttypeVO(int producttypeId, String producttypeName, long productNumberOfType) {
		super();
		this.producttypeId = producttypeId;
		this.producttypeName = producttypeName;
		this.productNumberOfType = productNumberOfType;
	}

	public int getProducttypeId() {
		return producttypeId;
	}

	public void setProducttypeId(int producttypeId) {
		this.producttypeId = producttypeId;
	}

	public String getProducttypeName() {
		return producttypeName;
	}

	public void setProducttypeName(String producttypeName) {
		this.producttypeName = producttypeName;
	}

	public long getProductNumberOfType() {
		return productNumberOfType;
	}

	public void setProductNumberOfType(long productNumberOfType) {
		this.productNumberOfType = productNumberOfType;
	}

	@Override
	public String toString() {
		return "ProducttypeVO [producttypeId=" + producttypeId + ", producttypeName=" + producttypeName
				+ ", productNumberOfType=" + productNumberOfType + "]";
	}

	
	
}
