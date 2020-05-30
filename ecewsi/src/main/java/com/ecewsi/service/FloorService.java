package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.FloorVO;

public interface FloorService {
	public void insertFloor(FloorVO floorVO);
	public List searchFloor();
	public List searchByIdFloor(FloorVO floorVO);

}
