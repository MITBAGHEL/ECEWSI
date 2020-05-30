package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.LoginDAO;
import com.ecewsi.model.LoginVO;
import com.ecewsi.model.RegisterVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO;
	
/*	@Transactional
	public void insertRegister(RegisterVO registerVO) {
		loginDAO.register(registerVO);
	}
*/
	@Transactional
	public void insertLogin(LoginVO loginVO) {
		loginDAO.insertLogin(loginVO);
	}

	@Transactional
	public List searchLoginID(String loginService) {
		List ls = loginDAO.searchLoginID(loginService);
		return ls;
	}

	@Transactional
	public List geLoginVo(String user) {
		List list = this.loginDAO.getLoginVo(user);
		return list;
	}

	@Override
	public List getUserCount() {
		return this.loginDAO.getUserCount();
	}

	@Override
	public List getComplaintCount() {
		return this.loginDAO.getComplaintCount();
	}

	@Override
	public List getFeedBackCount() {
		return this.loginDAO.getFeedBackCount();
	}

	@Override
	public List getAverageFeedbackCount() {
		return this.loginDAO.getAverageFeedbackCount();
	}

	@Override
	public List orderCount(int loginId) {
		return this.loginDAO.orderCount(loginId);
	}

	@Override
	public List userComplaintCount(int loginId) {
		return this.loginDAO.userComplaintCount(loginId);
	}

}
