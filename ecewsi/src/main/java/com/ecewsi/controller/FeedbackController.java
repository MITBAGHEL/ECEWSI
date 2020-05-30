package com.ecewsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.ComplaintVO;
import com.ecewsi.model.FeedbackVO;
import com.ecewsi.model.LoginVO;
import com.ecewsi.service.FeedbackService;
import com.ecewsi.service.LoginService;
import com.ecewsi.utils.Basemethods;

@Controller
public class FeedbackController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	FeedbackService feedbackService;
	
	
	/*********For Admin View***********/
	
	@RequestMapping(value="admin/viewFeedback",method=RequestMethod.GET)
	public ModelAndView seeComplaint(@ModelAttribute FeedbackVO feedbackVO) {
		String userName=Basemethods.getUser();
		List loginList =loginService.searchLoginID(userName);
		LoginVO loginVO2=(LoginVO) loginList.get(0);
		feedbackVO.setLoginVO(loginVO2);
		List feedbackList = this.feedbackService.searchFeedback(feedbackVO);
		return new ModelAndView("admin/viewFeedback" , "feedbackList" , feedbackList);
	
		
	}
	
	/*********For User Feedback***********/
	
	@RequestMapping(value="user/addFeedback", method= RequestMethod.GET)
	public ModelAndView loadFeedback(@ModelAttribute FeedbackVO feedbackVO) {
		
		return new ModelAndView("user/addFeedback" , "FeedbackVO" , new FeedbackVO());
	}
	
	@RequestMapping(value="user/insertFeedback", method= RequestMethod.POST)
	public ModelAndView insertFeedback(@ModelAttribute FeedbackVO feedbackVO) {
		
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		feedbackVO.setLoginVO(loginVO2);
		
		feedbackVO.setStatus(true);
		this.feedbackService.insertFeedback(feedbackVO);
		return new ModelAndView("redirect:/user/addFeedback");
	}
	@RequestMapping(value ="user/viewFeedback", method = RequestMethod.GET)
	public ModelAndView searchFeedback(@ModelAttribute FeedbackVO feedbackVO) {
	
		
		
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
    	
    	/*System.out.println(userName);*/
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		feedbackVO.setLoginVO(loginVO2);
		
		List feedbackList = this.feedbackService.seeFeedback(feedbackVO);
		
		return new ModelAndView("user/viewFeedback","feedbackList",feedbackList);
	}
	
	/*@RequestMapping(value="user/viewComplain",method=RequestMethod.GET)
	public ModelAndView seeComplaint(@ModelAttribute ComplaintVO complaintVO) {
		
		
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
    	
    	System.out.println(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		complaintVO.setLoginVO(loginVO2);
		
		List complaintList = this.complaintService.seeComplaint(complaintVO);
		
		return new ModelAndView("user/viewComplain","complaintList",complaintList);
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
/*	@RequestMapping(value="user/deleteFeedback", method= RequestMethod.GET)
	public ModelAndView feedbackSearchById(@ModelAttribute FeedbackVO feedbackVO, @RequestParam int id) {
		feedbackVO.getId();
		List feedbackList = feedbackService.feedbackSearchById(feedbackVO);
		
		FeedbackVO feedbackSearchList = (FeedbackVO) feedbackList.get(0);
		feedbackSearchList.setStatus(false);
		feedbackService.insertFeedback(feedbackSearchList);
		return new ModelAndView("redirect:/user/viewFeedback");
	}
	
	@RequestMapping(value="user/editFeedback" , method = RequestMethod.GET)
	public ModelAndView editFeedback(@ModelAttribute FeedbackVO feedbackVO, @RequestParam int id) {
		feedbackVO.getId();
		List feedbackList = this.feedbackService.feedbackSearchById(feedbackVO);
		FeedbackVO feedbackSearchList = (FeedbackVO) feedbackList.get(0);
		return new ModelAndView("user/addFeedback" , "FeedbackVO" , feedbackSearchList);
	}*/
	
}
