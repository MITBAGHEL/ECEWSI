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
@Table(name="product_master")
public class ProductVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="productname")
	private String productname;
	
	@Column(name="brandName")
	private String brandName;
	
	@ManyToOne
	@JoinColumn(name="rackId")
	private RackVO rackVO;
	
	@Column(name="brandDiscription")
	private String brandDiscription;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private CategoryVO categoryVO;
	
	@ManyToOne
	@JoinColumn(name="subcategoryId")
	private SubCategoryVO subCategoryVO;

	@ManyToOne
	@JoinColumn(name="loginId")
	private LoginVO loginVO;
	
	@Column(name="s3productLink")
	private String s3productLink;
	
	@Column(name="status")
	private boolean status=true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public RackVO getRackVO() {
		return rackVO;
	}

	public void setRackVO(RackVO rackVO) {
		this.rackVO = rackVO;
	}

	public String getBrandDiscription() {
		return brandDiscription;
	}

	public void setBrandDiscription(String brandDiscription) {
		this.brandDiscription = brandDiscription;
	}

	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	public SubCategoryVO getSubCategoryVO() {
		return subCategoryVO;
	}

	public void setSubCategoryVO(SubCategoryVO subCategoryVO) {
		this.subCategoryVO = subCategoryVO;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public String getS3productLink() {
		return s3productLink;
	}

	public void setS3productLink(String s3productLink) {
		this.s3productLink = s3productLink;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	


}
