package com.ecewsi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.LoginVO;
import com.ecewsi.model.RegisterVO;
import com.ecewsi.service.LoginService;
import com.ecewsi.service.RegisterService;
import com.ecewsi.utils.Basemethods;

@Controller
public class LoginController implements ErrorController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginVO loginVO) {

		List userCount = this.loginService.getUserCount();
		List complaintCount = this.loginService.getComplaintCount();
		List feedbackCount = this.loginService.getFeedBackCount();
		List averageFeedbackCount = this.loginService.getAverageFeedbackCount();
		
		
		Object numberOfUser = 0;
		Object numberOfComplaint = 0;
		Object numberOfFeedback = 0;
		Object numberOfAvgFeedback = 0;
		
		if(!userCount.isEmpty()){
			numberOfUser = userCount.get(0);
		}
		
		if(!complaintCount.isEmpty()){
			numberOfComplaint = complaintCount.get(0);
		}
		
		if(!feedbackCount.isEmpty()){
			numberOfFeedback = feedbackCount.get(0);
		}
		
		if(!averageFeedbackCount.isEmpty()){
			numberOfAvgFeedback = averageFeedbackCount.get(0);
		}

		return new ModelAndView("admin/index").addObject("userCount", numberOfUser.toString())
				.addObject("complaintCount", numberOfComplaint.toString()).addObject("feedbackCount", numberOfFeedback.toString())
				.addObject("avgfeedbackCount", numberOfAvgFeedback.toString());
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex() {

		String userName = Basemethods.getUser();
		List loginList = loginService.searchLoginID(userName);

		LoginVO loginVO = (LoginVO) loginList.get(0);
		List registerList = this.registerService.seachByLoginId(loginVO.getLoginId());
		
		RegisterVO registerVO = (RegisterVO)registerList.get(0);
		
		if(registerVO.isProfileEditedOrNot()){
		
			List userCount = this.loginService.getUserCount();
			List productCount =  this.loginService.orderCount(loginVO.getLoginId());
			List complaintCount =  this.loginService.userComplaintCount(loginVO.getLoginId());
			List averageFeedbackCount = this.loginService.getAverageFeedbackCount();
			
			
			Object numberOfUser = 0;
			Object numberOfComplaint = 0;
			Object numberOfOrder = 0;
			Object numberOfAvgFeedback = 0;
			
			if(!userCount.isEmpty()){
				numberOfUser = userCount.get(0);
			}
			
			if(!complaintCount.isEmpty()){
				numberOfComplaint = complaintCount.get(0);
			}
			
			if(!productCount.isEmpty()){
				numberOfOrder = productCount.get(0);
			}
			
			if(!averageFeedbackCount.isEmpty()){
				numberOfAvgFeedback = averageFeedbackCount.get(0);
			}

			return new ModelAndView("user/index").addObject("userCount", numberOfUser.toString())
					.addObject("complaintCount", numberOfComplaint.toString()).addObject("numberOfOrder", numberOfOrder.toString())
					.addObject("avgfeedbackCount", numberOfAvgFeedback.toString());
		
		}else{
			return new ModelAndView("redirect:/user/editProfileData");
		}
		
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewUserDetails(ModelMap model, HttpServletResponse response, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
			request.getSession().setAttribute("tempStatus", "success");
			request.getSession().setAttribute("statusText", "Logout Successfully!");
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {

		return new ModelAndView("404");
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView error404() {

		return new ModelAndView("404");
	}

	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public ModelAndView error500() {

		return new ModelAndView("500");
	}

	@Override
	public String getErrorPath() {
		return "error";
	}

}