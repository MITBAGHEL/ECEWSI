package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.FloorVO;

@Repository
public class FloorDAOImpl implements FloorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertFloor(FloorVO floorVO)
	{
		try
		{
			Session session =this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(floorVO);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	public List searchFloor() {
		List floorList=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from FloorVO where status=true");
		floorList=q.list();
		return floorList;
	}


	public List searchByIdFloor(FloorVO floorVO) {
		List searchByIdFloor=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from FloorVO where status =true and id="+floorVO.getId());
		searchByIdFloor=q.list();
		return searchByIdFloor;
	}
}
