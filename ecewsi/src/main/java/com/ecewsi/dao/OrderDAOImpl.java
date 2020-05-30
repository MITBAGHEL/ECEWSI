package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.FeedbackVO;
import com.ecewsi.model.OrderVO;

import org.hibernate.SessionFactory;


@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List searchOrder(OrderVO orderVO) {
		List ls =new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from OrderVO where loginVO.loginId= '"+orderVO.getLoginVO().getLoginId()+"' GROUP BY purchaseDate");
		ls = q.list();
		return ls;
	}

	@Override
	public List getOrderById(int id,String purchaseDate) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from OrderVO where purchaseDate='"+purchaseDate+"' and loginVO.loginId= "+id);
		return q.list();
	}

}
