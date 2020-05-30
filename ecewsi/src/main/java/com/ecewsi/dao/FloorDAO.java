package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.FloorVO;

public interface FloorDAO {
	public void insertFloor(FloorVO floorVO);
	public List searchFloor();
	public List searchByIdFloor(FloorVO floorVO);

}
