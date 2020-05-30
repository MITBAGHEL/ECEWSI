package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.SubCategoryVO;

public interface SubCategoryService {
	public void insertSubCategory(SubCategoryVO subcategoryVO);
	public List searchSubCategory();
	public List searchByIdSubCategory(SubCategoryVO subcategoryVO);
}
