package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.StoreDAO;
import com.ecewsi.model.StoreVO;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreDAO storeDAO;
	
	@Override
	public void insertStore(StoreVO storeVO) {
		// TODO Auto-generated method stub
		this.storeDAO.insertStore(storeVO);
		
	}

	@Override
	public List searchStore() {
		// TODO Auto-generated method stub
		return this.storeDAO.searchStore();
	}

	@Override
	public List searchByIdStore(StoreVO storeVO) {
		// TODO Auto-generated method stub
		return this.storeDAO.searchByIdStore(storeVO);
	}

}
