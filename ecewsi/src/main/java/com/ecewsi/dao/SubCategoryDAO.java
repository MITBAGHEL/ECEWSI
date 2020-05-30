package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.SubCategoryVO;

public interface SubCategoryDAO {
	public void insertSubCategory(SubCategoryVO subcategoryVO);
	public List searchSubCategory();
	public List searchByIdSubCategory(SubCategoryVO subcategoryVO);
}
