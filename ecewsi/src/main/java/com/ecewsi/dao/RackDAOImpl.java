package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.FloorVO;
import com.ecewsi.model.RackVO;

@Repository
public class RackDAOImpl implements RackDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void insertRack(RackVO rackVO)
	{
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(rackVO);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List searchRack()
	{
			List rackList=new ArrayList();
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from RackVO where status=true");
			rackList=q.list();
			return rackList;
	}


		public List searchByIdRack(RackVO rackVO) {
			List searchByIdRack=new ArrayList();
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from RackVO where status =true and id="+rackVO.getId());
			searchByIdRack=q.list();
			return searchByIdRack;
		}
}
