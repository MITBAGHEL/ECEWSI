package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.BlockVO;

@Repository
public class BlockDAOImpl implements BlockDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void insertBlock(BlockVO blockVO)
	{
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(blockVO);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List searchBlock()
	{
		List blockList=new ArrayList();
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from BlockVO where status=true");
			blockList=q.list();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return blockList;
	}
	public List searchByIdBlock(BlockVO blockVO)
	{
		List blockById=new ArrayList();
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from BlockVO where status=true and id="+blockVO.getId());
			blockById=q.list();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return blockById;
	}

}
