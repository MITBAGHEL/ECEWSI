package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.LoginVO;
import com.ecewsi.model.RegisterVO;


public interface LoginDAO {
	public void insertLogin(LoginVO loginVO);

	public List searchLoginID(String loginService);

	public List getLoginVo(String user);

	public List getUserCount();

	public List getComplaintCount();

	public List getFeedBackCount();

	public List getAverageFeedbackCount();

	public List orderCount(int loginId);

	public List userComplaintCount(int loginId);

}
