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
@Table(name="subproduct_master")
public class SubProductVO {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="subProductName")
	private String subProductName;
	
	@Column(name="price")
	private String price;
	
	@Column(name="color")
	private String color;
	
	@Column(name="subProductDiscription")
	private String subProductDiscription;
	
	@Column(name="s3SubProductImagelink")
	private String subProductImagelink;
	

	@Column(name="status")
	private boolean status=true;
	
	@ManyToOne
	@JoinColumn(name="loginId")
	private LoginVO loginVO;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private CategoryVO categoryVO;
	
	@ManyToOne
	@JoinColumn(name="subCategoryId")
	private SubCategoryVO subCategoryVO;
	
	@ManyToOne
	@JoinColumn(name="rackId")
	private RackVO rackVO;
	
	@ManyToOne
	@JoinColumn(name="floorId")
	private FloorVO floorVO;
	
	@ManyToOne
	@JoinColumn(name="blockId")
	private BlockVO blockVO; 
	
	public FloorVO getFloorVO() {
		return floorVO;
	}

	public void setFloorVO(FloorVO floorVO) {
		this.floorVO = floorVO;
	}

	public BlockVO getBlockVO() {
		return blockVO;
	}

	public void setBlockVO(BlockVO blockVO) {
		this.blockVO = blockVO;
	}

	@ManyToOne
	@JoinColumn(name="storeId")
	private StoreVO storeVO;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private ProductVO productVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubProductName() {
		return subProductName;
	}

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSubProductDiscription() {
		return subProductDiscription;
	}

	public void setSubProductDiscription(String subProductDiscription) {
		this.subProductDiscription = subProductDiscription;
	}

	public String getSubProductImagelink() {
		return subProductImagelink;
	}

	public void setSubProductImagelink(String subProductImagelink) {
		this.subProductImagelink = subProductImagelink;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
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

	public RackVO getRackVO() {
		return rackVO;
	}

	public void setRackVO(RackVO rackVO) {
		this.rackVO = rackVO;
	}

	public StoreVO getStoreVO() {
		return storeVO;
	}

	public void setStoreVO(StoreVO storeVO) {
		this.storeVO = storeVO;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}
	
	
}
