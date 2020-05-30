package com.ecewsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="category_master")
public class CategoryVO 
{
	
	@Id
	@Column(name="cid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@Column(name="categoryDiscription")
	private String categoryDiscription;
	
	@Column(name="Status")
	private boolean status= true;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDiscription() {
		return categoryDiscription;
	}

	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
	
	



