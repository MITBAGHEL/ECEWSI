package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.RackVO;

public interface RackDAO {
	public void insertRack(RackVO rackVO);
	public List searchRack();
	public List searchByIdRack(RackVO rackVO);
}
