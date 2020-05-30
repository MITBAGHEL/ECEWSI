package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.LoginVO;
import com.ecewsi.model.RegisterVO;

public interface LoginService {
	
	public void insertLogin(LoginVO loginVO);

	public List searchLoginID(String loginService);

	public List geLoginVo(String user);

	public List getUserCount();

	public List getComplaintCount();

	public List getFeedBackCount();

	public List getAverageFeedbackCount();

	public List orderCount(int loginId);

	public List userComplaintCount(int loginId);

}
