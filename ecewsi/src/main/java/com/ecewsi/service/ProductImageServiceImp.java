package com.ecewsi.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.ProductImageDAO;
import com.ecewsi.model.ProductImageVO;

@Service
@Transactional
public class ProductImageServiceImp implements ProductImageService{

	@Autowired
	ProductImageDAO productImageDAO;
	
	public void insertProductImage(ProductImageVO productImageVO)
	{
		this.productImageDAO.insertProductImage(productImageVO);
	}
	
	public List searchProductImage(ProductImageVO productImageVO) {
		return this.productImageDAO.searchProductImage(productImageVO);
		
	}

	public List productImageSearchById(ProductImageVO productImageVO) {
		return this.productImageDAO.productImageSearchById(productImageVO);
	}

	public List deleteImages(ProductImageVO productImageVO) 
	{
		return this.productImageDAO.deleteImages(productImageVO);
	}
	
	public List searchByIdImage(ProductImageVO productImageVO)
	{
		return this.productImageDAO.searchByIdImage(productImageVO);
	}
	
	//public List seeDesigns(DesignImageVO designImageVO) {
		//return this.designImageDAO.seeDesigns(designImageVO);
	//}

}
