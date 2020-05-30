package com.ecewsi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.CategoryDAO;
import com.ecewsi.dao.ProductDAO;
import com.ecewsi.model.CategoryVO;
import com.ecewsi.model.ProductVO;
import com.ecewsi.model.SubProductVO;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductDAO productDAO;
	
	@Transactional
	public void insertProduct(ProductVO productVO)
	{
		this.productDAO.insertProduct(productVO);
	}
	
	@Transactional
	public List searchProduct(ProductVO productVO)
	{
		return this.productDAO.searchProduct(productVO);
	}
	
	@Transactional
	public List searchByIdProduct(ProductVO productVO)
	{
		return this.productDAO.searchByIdProduct(productVO);
	}

	
}
