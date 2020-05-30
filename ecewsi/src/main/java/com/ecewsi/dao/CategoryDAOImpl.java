
package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void insertCategory(CategoryVO categoryVO) 
	{
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(categoryVO);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	public List searchCategory() 
	{
		List searchCategory = new ArrayList();
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			Query sc = session.createQuery("from CategoryVO where status=true");
			searchCategory = sc.list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return searchCategory;
	}
	
	public List searchByIdCategory(CategoryVO categoryVO)
	{
		List searchByCategory = new ArrayList();
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from CategoryVO where status =true and id="+categoryVO.getId());
			searchByCategory=q.list();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return searchByCategory;
	}

}
