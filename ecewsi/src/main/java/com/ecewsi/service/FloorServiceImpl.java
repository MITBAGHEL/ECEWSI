package com.ecewsi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.FloorDAO;
import com.ecewsi.dao.SubCategoryDAO;
import com.ecewsi.model.FloorVO;
import com.ecewsi.model.SubCategoryVO;

@Service
public class FloorServiceImpl implements FloorService{

		@Autowired
		FloorDAO floorDAO;
		
		@Transactional
		public void insertFloor(FloorVO floorVO) {
			this.floorDAO.insertFloor(floorVO);
		}
		
		@Transactional
		public List searchFloor()
		{
			return this.floorDAO.searchFloor();
		}
		
		@Transactional
		public List searchByIdFloor(FloorVO floorVO)
		{
			return this.floorDAO.searchByIdFloor(floorVO);
		}

}