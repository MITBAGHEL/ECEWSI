package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.StoreVO;

public interface StoreService {
	public void insertStore(StoreVO storeVO);
	public List searchStore();
	public List searchByIdStore(StoreVO storeVO);
}
