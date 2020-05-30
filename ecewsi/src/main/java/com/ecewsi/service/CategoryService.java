package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.CategoryVO;

public interface CategoryService {
	
	public void insertCategory(CategoryVO categoryVO);
	public List searchCategory(CategoryVO categoryVO);
	public List searchByIdCategory(CategoryVO categoryVO);
	//public List searchByIdSubCategory(CategoryVO categoryVO);

}
