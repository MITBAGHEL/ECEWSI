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
@Table(name="categoryImage_master")
public class CategoryImageVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="status")
	private boolean status=true;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private CategoryVO categoryVO;
	
	@Column(name="s3CategoryImageLink")
	private String s3CategoryImageLink;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getS3CategoryImageLink() {
		return s3CategoryImageLink;
	}

	public void setS3CategoryImageLink(String s3CategoryImageLink) {
		this.s3CategoryImageLink = s3CategoryImageLink;
	}

}
