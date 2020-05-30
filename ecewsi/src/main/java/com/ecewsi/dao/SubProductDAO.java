package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.SubCategoryVO;
import com.ecewsi.model.SubProductVO;

public interface SubProductDAO {
	public void insertSubProduct(SubProductVO subProductVO);
	public List searchSubProduct(SubProductVO subProductVO);
	public List searchByIdSubProduct(SubProductVO subProductVO);

}
