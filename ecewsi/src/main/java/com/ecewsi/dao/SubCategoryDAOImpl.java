package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.CategoryVO;
import com.ecewsi.model.SubCategoryVO;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void insertSubCategory(SubCategoryVO subcategoryVO) {
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(subcategoryVO);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List searchSubCategory() {
		List searchCategory = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query sc = session.createQuery("from SubCategoryVO where status=true");
			searchCategory = sc.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return searchCategory;
	}
	
	public List searchByIdSubCategory(SubCategoryVO subcategoryVO)
	{
		List searchByCategory = new ArrayList();
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from SubCategoryVO where status =true and id="+subcategoryVO.getId());
			searchByCategory=q.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return searchByCategory;
	}


}
