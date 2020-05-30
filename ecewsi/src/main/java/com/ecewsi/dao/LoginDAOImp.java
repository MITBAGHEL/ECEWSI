package com.ecewsi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.LoginVO;
import com.ecewsi.model.RegisterVO;

@Repository
public class LoginDAOImp implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*public void register(RegisterVO registerVO) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(registerVO);
	}*/
	
	@Override
	public void insertLogin(LoginVO loginVO) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(loginVO);
	}
	@Override
	public List searchLoginID(String loginService) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '"+loginService+"' ");
		List ls = q.list();
		return ls;
	}
	@Override
	public List getLoginVo(String user) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '"+user+"' ");
		List ls = q.list();
		return ls;
	}
	
	@Override
	public List getUserCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from register_master");
		return q.list();
	}

	@Override
	public List getComplaintCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from complaint_master");
		return q.list();
	}

	@Override
	public List getAverageFeedbackCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("SELECT AVG(rate) FROM feedback_master");
		return q.list();
	}

	@Override
	public List getFeedBackCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from feedback_master");
		return q.list();
	}
	@Override
	public List orderCount(int loginId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from order_master where loginId="+loginId);
		return q.list();
	}
	@Override
	public List userComplaintCount(int loginId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from complaint_master where loginID="+loginId);
		return q.list();
	}
}