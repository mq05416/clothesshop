package com.spring.model;
// Generated May 4, 2017 8:08:51 PM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Agesex generated by hbm2java
 */
@Entity
@Table(name = "agesex", catalog = "clothesshop_v5")
public class Agesex implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private Set<Producttype> producttypes = new HashSet<Producttype>(0);

	public Agesex() {
	}

	public Agesex(String name, String description, Set<Producttype> producttypes) {
		this.name = name;
		this.description = description;
		this.producttypes = producttypes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "agesex")
	public Set<Producttype> getProducttypes() {
		return this.producttypes;
	}

	public void setProducttypes(Set<Producttype> producttypes) {
		this.producttypes = producttypes;
	}

}