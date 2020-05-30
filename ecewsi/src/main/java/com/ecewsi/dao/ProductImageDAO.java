package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.ProductImageVO;
import com.ecewsi.model.SubProductVO;

public interface ProductImageDAO {

	public void insertProductImage(ProductImageVO designImageVO);
	public List searchProductImage(ProductImageVO designImageVO);
	public List productImageSearchById(ProductImageVO designImageVO);
	public List deleteImages(ProductImageVO productImageVO);
	public List searchByIdImage(ProductImageVO productImageVO);
	
	//public List seeDesigns(DesignImageVO designImageVO);
}
