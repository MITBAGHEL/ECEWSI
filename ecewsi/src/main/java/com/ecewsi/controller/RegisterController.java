package com.ecewsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.LoginVO;
import com.ecewsi.model.RegisterVO;
import com.ecewsi.service.LoginService;
import com.ecewsi.service.RegisterService;
import com.ecewsi.utils.Basemethods;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView loadRegister() {

		System.out.print("This is Register page");
		return new ModelAndView("register", "registerVO", new RegisterVO());
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView goToHomePage(@ModelAttribute RegisterVO registerVO, LoginVO loginVO) {

		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
		loginVO.setEnabled("1");
		loginVO.setRole("ROLE_USER");
		loginVO.setStatus(true);
		this.loginService.insertLogin(loginVO);
		registerVO.setProfileEditedOrNot(true);
		registerVO.setLoginVO(loginVO);
		this.registerService.insertRegister(registerVO);

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "user/editProfileData", method = RequestMethod.GET)
	public ModelAndView editData() {
		List list = this.loginService.geLoginVo(Basemethods.getUser());
		System.out.println(list.size());
		LoginVO loginVO = (LoginVO) list.get(0);
		System.out.println(loginVO);
		List list2 = this.registerService.seachByLoginId(loginVO.getLoginId());
		System.out.println(list2.size());
		RegisterVO registerVO = (RegisterVO) list2.get(0);
		System.out.println(registerVO);
		return new ModelAndView("user/addProfileData", "registerVO1", registerVO);
	}

	@RequestMapping(value = "user/insertEditProfileData", method = RequestMethod.POST)
	public ModelAndView insertEditProfileData(@ModelAttribute RegisterVO registerVO) {
		LoginVO loginVO = registerVO.getLoginVO();
		
		this.loginService.insertLogin(loginVO);
		
		registerVO.setLoginVO(loginVO);
		registerVO.setProfileEditedOrNot(true);
		
		this.registerService.insertRegister(registerVO);
		// System.out.println(id2);
		return new ModelAndView("redirect:/user/index");
	}
}
