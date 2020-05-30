package com.ecewsi.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.CategoryDAO;
import com.ecewsi.model.CategoryVO;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Transactional
	public void insertCategory(CategoryVO categoryVO)
	{
		this.categoryDAO.insertCategory(categoryVO);
	}
	
	@Transactional
	public List searchCategory(CategoryVO categoryVO)
	{
		return this.categoryDAO.searchCategory();
	}
	
	@Transactional
	public List searchByIdCategory(CategoryVO categoryVO)
	{
		return this.categoryDAO.searchByIdCategory(categoryVO);
	}

	
}
