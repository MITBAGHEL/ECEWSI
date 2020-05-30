package com.ecewsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.BlockVO;

@Controller
public class invoiceController {

	@RequestMapping(value = "user/invoice", method = RequestMethod.GET)
	public ModelAndView loadBlock(@ModelAttribute BlockVO blockVO) {
		return new ModelAndView("user/invoice", "BlockVO", new BlockVO());
	}

}
