package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.BlockVO;

public interface BlockService {
	public void insertBlock(BlockVO blockVO);
	public List searchBlock();
	public List searchByIdBlock(BlockVO blockVO);
}
