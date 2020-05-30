package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.StoreVO;

@Repository
public class StoreDAOImpl implements StoreDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertStore(StoreVO storeVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(storeVO);
	}

	@Override
	public List searchStore() {
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from StoreVO where status=true");
		ls=q.list();
		return ls;
	}

	@Override
	public List searchByIdStore(StoreVO storeVO) {
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from StoreVO where status =true and id="+storeVO.getId());
		ls=q.list();
		return ls;
	}
}
