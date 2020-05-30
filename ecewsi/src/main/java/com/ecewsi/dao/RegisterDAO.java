package com.ecewsi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ecewsi.model.RegisterVO;

public interface RegisterDAO {

	public void insertRegister(RegisterVO registerVO);

	public List seachByLoginId(int loginId);
	
	public List searchByEmailId(String email);

}
