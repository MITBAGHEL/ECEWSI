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
@Table(name="subcategory_master")
public class SubCategoryVO {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="subCategoryName")
	private String subCategoryName;
	
	@Column(name="subCategoryDiscription")
	private String subCategoryDiscription;
	
	@Column
	private String link;
	
	@Column(name="status")
	private boolean status=true;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private CategoryVO categoryVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getSubCategoryDiscription() {
		return subCategoryDiscription;
	}

	public void setSubCategoryDiscription(String subCategoryDiscription) {
		this.subCategoryDiscription = subCategoryDiscription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	

}
