package com.ecewsi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.SubCategoryDAO;
import com.ecewsi.model.SubCategoryVO;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

		@Autowired
		SubCategoryDAO subcategoryDAO;
		
		@Transactional
		public void insertSubCategory(SubCategoryVO subcategoryVO) {
			this.subcategoryDAO.insertSubCategory(subcategoryVO);
		}
		@Transactional
		public List searchSubCategory()
		{
			return this.subcategoryDAO.searchSubCategory();
		}
		
		@Transactional
		public List searchByIdSubCategory(SubCategoryVO subcategoryVO)
		{
			return this.subcategoryDAO.searchByIdSubCategory(subcategoryVO);
		}		
}
