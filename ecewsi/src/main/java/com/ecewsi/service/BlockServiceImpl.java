package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.BlockDAO;
import com.ecewsi.model.BlockVO;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

	@Autowired
	BlockDAO blockDAO;
	
	public void insertBlock(BlockVO blockVO)
	{
		this.blockDAO.insertBlock(blockVO);
	}
	
	public List  searchBlock()
	{
		return this.blockDAO.searchBlock();
	}
	
	public List searchByIdBlock(BlockVO blockVO)
	{
		return this.blockDAO.searchByIdBlock(blockVO);
	}
	
	
}
