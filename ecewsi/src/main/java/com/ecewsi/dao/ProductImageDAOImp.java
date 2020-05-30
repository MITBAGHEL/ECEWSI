package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.ProductImageVO;
import com.ecewsi.model.SubProductVO;

@Repository
public class ProductImageDAOImp implements ProductImageDAO{


	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertProductImage(ProductImageVO productImageVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(productImageVO);
	}

	public List searchProductImage(ProductImageVO productImageVO) {
		List designImageSearchList = new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ProductImageVO where status = true ");
		designImageSearchList = q.list();
		return designImageSearchList;
	}

	public List productImageSearchById(ProductImageVO productImageVO) {
		List designImageSearchList = new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ProductImageVO where status = true and id="+productImageVO.getId());
		designImageSearchList = q.list();
		return designImageSearchList;
	}

	@Override
	public List deleteImages(ProductImageVO productImageVO) {
		// TODO Auto-generated method stub
		List deleteImageList=new ArrayList();
		Session session =this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ProductImageVO where id="+productImageVO.getId());
		deleteImageList=q.list();
		return deleteImageList;
	}

	public List searchByIdImage(ProductImageVO productImageVO)
	{
		List searchImage=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ProductImageVO where status=true and productVO.id="+productImageVO.getProductVO().getId());
		searchImage =q.list();
		return searchImage;
	}
	
	
	//public List seeDesigns(DesignImageVO designImageVO) {
		//Session session = sessionFactory.getCurrentSession();
		
		//Query q = session.createQuery("from ProductVO where loginVO.loginId = '"+designImageVO.getLoginVO().getLoginId()+"'");
		//List designImageSearchList = q.list();
		//return designImageSearchList;
	//}
	
}
