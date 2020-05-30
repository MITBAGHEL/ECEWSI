package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.RackDAO;
import com.ecewsi.model.RackVO;

@Service
@Transactional
public class RackServiceImpl implements RackService{

	@Autowired
	RackDAO rackDAO;
	
	public void insertRack(RackVO rackVO)
	{
		this.rackDAO.insertRack(rackVO);
	}
	public List searchRack()
	{
		return this.rackDAO.searchRack();
	}
	
	public List searchByIdRack(RackVO rackVO)
	{
		return this.rackDAO.searchByIdRack(rackVO);
	}
}
