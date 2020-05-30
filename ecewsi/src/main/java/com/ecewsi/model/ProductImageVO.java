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
@Table(name="productImage_master")
public class ProductImageVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(name="s3ProductLink")
	private String s3ProductLink;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private ProductVO productVO;
	
	@Column(name="status")
	private boolean status=true;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getS3ProductLink() {
		return s3ProductLink;
	}


	public void setS3ProductLink(String s3ProductLink) {
		this.s3ProductLink = s3ProductLink;
	}


	

	public ProductVO getProductVO() {
		return productVO;
	}


	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
}
