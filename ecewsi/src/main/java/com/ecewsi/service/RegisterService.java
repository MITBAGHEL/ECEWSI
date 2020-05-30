package com.ecewsi.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ecewsi.model.RegisterVO;

public interface RegisterService {

	void insertRegister(RegisterVO registerVO);

	List seachByLoginId(int loginId);
	
	public List searchByEmailId(String email);

}
