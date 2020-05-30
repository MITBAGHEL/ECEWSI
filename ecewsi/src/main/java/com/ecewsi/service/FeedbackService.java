package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.FeedbackVO;

public interface FeedbackService {
	

	public void insertFeedback(FeedbackVO feedbackVO);
	
	public List searchFeedback(FeedbackVO feedbackVO);
	
	public List feedbackSearchById(FeedbackVO feedbackVO);
	
	public List seeFeedback(FeedbackVO feedbackVO);

}
