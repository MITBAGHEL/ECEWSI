package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.FeedbackDAO;
import com.ecewsi.model.FeedbackVO;

@Service
@Transactional
public class FeedbackServiceImp implements FeedbackService{

	@Autowired
	FeedbackDAO feedbackDAO;

	public void insertFeedback(FeedbackVO feedbackVO) {
		this.feedbackDAO.insertFeedback(feedbackVO);
	}

	public List searchFeedback(FeedbackVO feedbackVO) {
		return this.feedbackDAO.searchFeedback(feedbackVO);
	}

	public List feedbackSearchById(FeedbackVO feedbackVO) {
		return this.feedbackDAO.feedbackSearchById(feedbackVO);
	}

	@Override
	public List seeFeedback(FeedbackVO feedbackVO) {
		// TODO Auto-generated method stub
		return this.feedbackDAO.seeFeedback(feedbackVO);
	}

	
}
