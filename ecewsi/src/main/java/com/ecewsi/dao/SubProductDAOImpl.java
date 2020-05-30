package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.SubCategoryVO;
import com.ecewsi.model.SubProductVO;


@Repository
public class SubProductDAOImpl implements SubProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void insertSubProduct(SubProductVO subProductVO) {
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(subProductVO);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List searchSubProduct(SubProductVO subProductVO) {
		List searchCategory = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query sc = session.createQuery("from SubProductVO where status=true");
			searchCategory = sc.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return searchCategory;
	}
	
	public List searchByIdSubProduct(SubProductVO subProductVO)
	{
		List searchByCategory = new ArrayList();
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from SubProductVO where status =true and id="+subProductVO.getId());
			searchByCategory=q.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return searchByCategory;
	}
	
}
