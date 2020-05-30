package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.SubProductDAO;
import com.ecewsi.model.SubProductVO;

@Service
@Transactional
public class SubProductServiceImpl implements SubProductService{

	@Autowired
	SubProductDAO subProductDAO;
	
	@Override
	public void insertSubProduct(SubProductVO subProductVO) {
		// TODO Auto-generated method stub
		this.subProductDAO.insertSubProduct(subProductVO);
		
	}

	@Override
	public List searchSubProduct(SubProductVO subProductVO) {
		// TODO Auto-generated method stub
		return this.subProductDAO.searchSubProduct(subProductVO);
	}

	@Override
	public List searchByIdSubProduct(SubProductVO subProductVO) {
		// TODO Auto-generated method stub
		return this.subProductDAO.searchByIdSubProduct(subProductVO);
	}

}
