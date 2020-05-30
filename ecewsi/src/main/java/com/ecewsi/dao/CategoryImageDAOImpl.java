package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.CategoryImageVO;
import com.ecewsi.model.ProductImageVO;
@Repository
public class CategoryImageDAOImpl implements CategoryImageDAO{


	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertCategoryImage(CategoryImageVO categoryImageVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(categoryImageVO);
	}

	public List searchCategoryImage(CategoryImageVO categoryImageVO) {
		List designImageSearchList = new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CategoryImageVO where status = true ");
		designImageSearchList = q.list();
		return designImageSearchList;
	}

	public List categoryImageSearchById(CategoryImageVO categoryImageVO) {
		List designImageSearchList = new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CategoryImageVO where status = true and id="+categoryImageVO.getId());
		designImageSearchList = q.list();
		return designImageSearchList;
	}

	/*@Override
	public List deleteImages(ProductImageVO productImageVO) {
		// TODO Auto-generated method stub
		List deleteImageList=new ArrayList();
		Session session =this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ProductImageVO where id="+productImageVO.getId());
		deleteImageList=q.list();
		return deleteImageList;
	}*/

	public List searchByIdImage(CategoryImageVO categoryImageVO)
	{
		List searchImage=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from CategoryImageVO where status=true and productVO.id="+categoryImageVO.getCategoryVO().getId());
		searchImage =q.list();
		return searchImage;
	}

	
}
