package com.spring.model;
// Generated May 11, 2017 12:39:31 PM by Hibernate Tools 5.2.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "test111")
@Indexed
public class Product implements java.io.Serializable {

	private Integer id;
	private Producttype producttype;
	private Supplier supplier;
	private String name;
	private String description;
	private String image;
	private Integer quantity;
	private String unit;
	private Double price;
	private Double discount;
	private Date discountStartDate;
	private Date discountEndDate;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Double rating;
	private Set<Orderdetail> orderdetails = new HashSet<Orderdetail>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	public Product() {
	}

	public Product(Producttype producttype, Supplier supplier, String name, String description, String image,
			Integer quantity, String unit, Double price, Double discount, Date discountStartDate, Date discountEndDate,
			Date createdDate, String createdBy, Date updatedDate, String updatedBy, Double rating,
			Set<Orderdetail> orderdetails, Set<Comment> comments) {
		this.producttype = producttype;
		this.supplier = supplier;
		this.name = name;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.unit = unit;
		this.price = price;
		this.discount = discount;
		this.discountStartDate = discountStartDate;
		this.discountEndDate = discountEndDate;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.rating = rating;
		this.orderdetails = orderdetails;
		this.comments = comments;
	}

	@Id
	/*@GeneratedValue(strategy = IDENTITY)*/

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_ProductType")
	@JsonIgnore
	public Producttype getProducttype() {
		return this.producttype;
	}

	public void setProducttype(Producttype producttype) {
		this.producttype = producttype;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_Supplier")
	@JsonIgnore
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Column(name = "Name", length = 250)
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.YES)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "Unit", length = 50)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "Price", scale = 4)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "Discount", precision = 22, scale = 0)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Discount_Start_Date", length = 19)
	public Date getDiscountStartDate() {
		return this.discountStartDate;
	}

	public void setDiscountStartDate(Date discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Discount_End_Date", length = 19)
	public Date getDiscountEndDate() {
		return this.discountEndDate;
	}

	public void setDiscountEndDate(Date discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedDate", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CreatedBy", length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdatedDate", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UpdatedBy", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "Rating", precision = 22, scale = 0)
	public Double getRating() {
		return this.rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	@JsonIgnore
	public Set<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
