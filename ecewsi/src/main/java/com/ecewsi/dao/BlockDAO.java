package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.BlockVO;

public interface BlockDAO {
	public void insertBlock(BlockVO blockVO);
	public List searchBlock();
	public List searchByIdBlock(BlockVO blockVO);

}
