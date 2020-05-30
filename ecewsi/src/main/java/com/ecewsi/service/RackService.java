package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.RackVO;

public interface RackService {
	public void insertRack(RackVO rackVO);
	public List searchRack();
	public List searchByIdRack(RackVO rackVO);

}
