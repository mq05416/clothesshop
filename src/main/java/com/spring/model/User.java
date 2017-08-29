package com.spring.model;
// Generated May 4, 2017 8:08:51 PM by Hibernate Tools 5.2.1.Final

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "test111", uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class User implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private Integer gender;
	private String firstname;
	private String lastname;
	private Date dob;
	private String email;
	private String phone;
	private String image;
	private String address;
	private String uuid;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Boolean isEnabled;
	private Boolean isLocked;
	private Boolean isDeleted;
	private Date lastLoginDate;
	private Date lastChangePassword;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Role> roles = new HashSet<Role>(0);

	public User() {
	}

	public User(String username, String password, Integer gender, String firstname, String lastname, Date dob,
			String email, String phone, String image, String address, String uuid, Date createdDate, String createdBy,
			Date updatedDate, String updatedBy, Boolean isEnabled, Boolean isLocked, Boolean isDeleted,
			Date lastLoginDate, Date lastChangePassword, Set<Order> orders, Set<Comment> comments, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.address = address;
		this.uuid = uuid;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isEnabled = isEnabled;
		this.isLocked = isLocked;
		this.isDeleted = isDeleted;
		this.lastLoginDate = lastLoginDate;
		this.lastChangePassword = lastChangePassword;
		this.orders = orders;
		this.comments = comments;
		this.roles = roles;
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

	@Column(name = "Username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "Firstname")
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "Lastname")
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DOB", length = 19)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "Email", unique = true, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Image", length = 50)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Address", length = 250)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "UUID")
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	@Column(name = "IsEnabled")
	public Boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(name = "IsLocked")
	public Boolean getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	@Column(name = "IsDeleted")
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastLoginDate", length = 19)
	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastChangePassword", length = 19)
	public Date getLastChangePassword() {
		return this.lastChangePassword;
	}

	public void setLastChangePassword(Date lastChangePassword) {
		this.lastChangePassword = lastChangePassword;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "userrole", catalog = "test111", joinColumns = {
			@JoinColumn(name = "Id_User", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Id_Role", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
