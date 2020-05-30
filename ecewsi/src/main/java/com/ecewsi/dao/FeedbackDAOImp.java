package com.ecewsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecewsi.model.ComplaintVO;
import com.ecewsi.model.FeedbackVO;

@Repository
public class FeedbackDAOImp implements FeedbackDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertFeedback(FeedbackVO feedbackVO) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(feedbackVO);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List searchFeedback(FeedbackVO feedbackVO) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from FeedbackVO where status = true ");
		List feedbackSearchList = q.list();
		return feedbackSearchList;
	}

	public List feedbackSearchById(FeedbackVO feedbackVO) {
		List feedbackSearchList = new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from FeedbackVO where status = true and id="+feedbackVO.getId());
		feedbackSearchList = q.list();
		return feedbackSearchList;
	}

	public List seeFeedback(FeedbackVO feedbackVO) {
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from FeedbackVO where loginVO.loginId = '"+feedbackVO.getLoginVO().getLoginId()+"'");
		List complainList = q.list();
		return complainList;
	}
	
	
	/*public List seeComplaint(FeedbackVO feedbackVO) {
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from feedbackVO where loginVO.loginId = '"+feedbackVO.getLoginVO().getLoginId()+"'");
		List complainList = q.list();
		return complainList;
	   }*/

	
}
