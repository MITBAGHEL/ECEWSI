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
public class RegisterDAOImp implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertRegister(RegisterVO registerVO) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(registerVO);
	}

	@Override
	public List seachByLoginId(int loginId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from RegisterVO where loginVO.loginId= "+loginId);
		return q.list();
	}

	@Override
	public List searchByEmailId(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username= "+email);
		return q.list();
	}
	
	

}
