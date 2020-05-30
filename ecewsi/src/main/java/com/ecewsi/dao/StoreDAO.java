package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.StoreVO;

public interface StoreDAO {
	public void insertStore(StoreVO storeVO);
	public List searchStore();
	public List searchByIdStore(StoreVO storeVO);
}
