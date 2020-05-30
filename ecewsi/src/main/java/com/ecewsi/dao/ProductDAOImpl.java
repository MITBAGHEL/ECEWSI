package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.SubProductVO;
import com.ecewsi.model.ProductVO;
import com.ecewsi.model.RackVO;


@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertProduct(ProductVO productVO) {
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(productVO);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List searchProduct(ProductVO productVO)
	{
			List productList=new ArrayList();
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProductVO where status=true");
			productList=q.list();
			return productList;
	}
		public List searchByIdProduct(ProductVO productVO) 
		{
			List searchByIdProduct=new ArrayList();
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProductVO where status =true and id="+productVO.getId());
			searchByIdProduct=q.list();
			return searchByIdProduct;
		}
		
}
