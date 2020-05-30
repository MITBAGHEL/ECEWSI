package com.ecewsi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.LoginVO;
import com.ecewsi.model.OrderVO;
import com.ecewsi.model.RegisterVO;
import com.ecewsi.model.SubProductVO;
import com.ecewsi.service.LoginService;
import com.ecewsi.service.OrderService;
import com.ecewsi.service.RegisterService;
import com.ecewsi.service.SubProductService;
import com.ecewsi.utils.Basemethods;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	LoginService loginService;

	@Autowired
	RegisterService registerService;

	@Autowired
	SubProductService subProductService;

	@RequestMapping(value = "user/viewOrder", method = RequestMethod.GET)
	public ModelAndView searchFeedback(@ModelAttribute OrderVO orderVO) {

		String userName = Basemethods.getUser();
		List loginList = loginService.searchLoginID(userName);
		LoginVO loginVO = (LoginVO) loginList.get(0);

		List registerList = this.registerService.seachByLoginId(loginVO.getLoginId());
		RegisterVO registerVO = (RegisterVO) registerList.get(0);

		if (registerVO.isProfileEditedOrNot()) {

			orderVO.setLoginVO(loginVO);
			List orderList = this.orderService.searchOrder(orderVO);

			return new ModelAndView("user/viewOrder", "orderList", orderList);
		} else {
			return new ModelAndView("redirect:/user/editProfileData");
		}
	}

	@RequestMapping(value = "user/generateInvoiceById", method = RequestMethod.GET)
	public ModelAndView generateInvoice(@ModelAttribute OrderVO orderVO, @RequestParam int id,
			@RequestParam String purchaseDate) {
		List productList  = new ArrayList();
		double subTotal = 0.0;
		System.out.println("purchaseDate : "+purchaseDate);
		List orderList = this.orderService.getOrderById(id,purchaseDate);

		System.out.println("orderList : "+orderList.size());
		
		for (int i = 0; i < orderList.size(); i++) {
			orderVO = (OrderVO) orderList.get(i);
			
			List subProductList = this.subProductService.searchByIdSubProduct(orderVO.getProductVO());
			productList.add(subProductList);
			
			SubProductVO subProductVO = (SubProductVO)subProductList.get(0);
			System.out.println("******** "+subProductVO.getSubProductName()+" ******");
			
			double price  = Double.parseDouble(subProductVO.getPrice());
			subTotal =subTotal+price; 
		}
		System.out.println("productList :" + productList.size());
		System.out.println("subTotal "+subTotal);
		
		orderVO = (OrderVO) orderList.get(0);
		System.out.println("loginid : " + orderVO.getLoginVO().getLoginId());
		System.out.println("suproducttId : " + orderVO.getProductVO().getId());

		List registerList = this.registerService.seachByLoginId(orderVO.getLoginVO().getLoginId());
		System.out.println("registerList : " + registerList.size());

		
		return new ModelAndView("user/invoice", "orderList", orderList.get(0))
				.addObject("registerList", registerList.get(0)).addObject("productList", productList)
				.addObject("subTotal",subTotal);
	}

}
