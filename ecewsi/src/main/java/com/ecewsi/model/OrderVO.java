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
@Table(name="order_master")
public class OrderVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderId")
	private int id;
	
	@ManyToOne 
	@JoinColumn(name="loginId")
	private LoginVO loginVO;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private SubProductVO productVO;
	
	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name="purchaseDate")
	private String purchaseDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	

	public SubProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(SubProductVO productVO) {
		this.productVO = productVO;
	}


	
	

}
