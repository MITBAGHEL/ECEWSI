package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.CategoryImageVO;

public interface CategoryImageService {

	public void insertCategoryImage(CategoryImageVO designImageVO);
	public List searchCategoryImage(CategoryImageVO designImageVO);
	public List categoryImageSearchById(CategoryImageVO designImageVO);
	//public List deleteImages(CategoryImageVO categoryImageVO);
	public List searchByIdImage(CategoryImageVO categoryImageVO);
}
