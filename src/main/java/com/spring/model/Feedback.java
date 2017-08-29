package com.spring.model;
// Generated May 4, 2017 8:08:51 PM by Hibernate Tools 5.2.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Feedback generated by hbm2java
 */
@Entity
@Table(name = "feedback", catalog = "test111")
public class Feedback implements java.io.Serializable {

	private int id;
	private String subject;
	private String message;
	private String name;
	private String contactNumber;
	private String email;
	private Date createdDate;

	public Feedback() {
	}

	public Feedback(int id) {
		this.id = id;
	}

	public Feedback(int id, String subject, String message, String name, String contactNumber, String email,
			Date createdDate) {
		this.id = id;
		this.subject = subject;
		this.message = message;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.createdDate = createdDate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Subject")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "Message", length = 65535)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ContactNumber")
	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "Email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedDate", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
