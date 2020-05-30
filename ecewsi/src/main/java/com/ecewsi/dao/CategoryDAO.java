package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.CategoryVO;

public interface CategoryDAO 
{
	public void insertCategory(CategoryVO categoryVO);
	public List searchCategory();
	public List searchByIdCategory(CategoryVO categoryVO);
}
