package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.ProductVO;
import com.ecewsi.model.SubProductVO;

public interface ProductDAO {
	public void insertProduct(ProductVO productVO);
	public List searchProduct(ProductVO productVO);
	public List searchByIdProduct(ProductVO productVO);
	
}
