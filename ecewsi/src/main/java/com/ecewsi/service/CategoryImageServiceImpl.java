package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.CategoryImageDAO;
import com.ecewsi.dao.ProductImageDAO;
import com.ecewsi.model.CategoryImageVO;
import com.ecewsi.model.ProductImageVO;

@Service
@Transactional
public class CategoryImageServiceImpl implements CategoryImageService {
	@Autowired
	CategoryImageDAO categoryImageDAO;
	
	public void insertCategoryImage(CategoryImageVO categoryImageVO)
	{
		this.categoryImageDAO.insertCategoryImage(categoryImageVO);
	}
	
	public List searchCategoryImage(CategoryImageVO categoryImageVO) {
		return this.categoryImageDAO.searchCategoryImage(categoryImageVO);
		
	}

	public List categoryImageSearchById(CategoryImageVO categoryImageVO) {
		return this.categoryImageDAO.categoryImageSearchById(categoryImageVO);
	}
	
	public List searchByIdImage(CategoryImageVO categoryImageVO)
	{
		return this.categoryImageDAO.searchByIdImage(categoryImageVO);
	}

}
