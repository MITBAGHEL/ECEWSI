package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.ProductImageVO;

public interface ProductImageService {

	public void insertProductImage(ProductImageVO ProuctImageVO);
	public List searchProductImage(ProductImageVO ProuctImageVO);
	public List productImageSearchById(ProductImageVO ProuctImageVO);
	public List deleteImages(ProductImageVO productImageVO); 
	public List searchByIdImage(ProductImageVO productImageVO);
	
	//public List seeDesigns(ProuctImageVO ProuctImageVO);
}
