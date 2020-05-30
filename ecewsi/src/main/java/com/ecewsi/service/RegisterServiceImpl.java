package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.RegisterDAO;
import com.ecewsi.model.RegisterVO;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterDAO registerDAO;

	
	public void insertRegister(RegisterVO registerVO) {
		this.registerDAO.insertRegister(registerVO);
	}

	@Override
	public List seachByLoginId(int loginId) {
		return this.registerDAO.seachByLoginId(loginId);
	}

	@Override
	public List searchByEmailId(String email) {
		// TODO Auto-generated method stub
		return this.registerDAO.searchByEmailId(email);
	}

}
