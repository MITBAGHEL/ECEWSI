package com.ecewsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecewsi.dao.OrderDAO;
import com.ecewsi.model.OrderVO;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	public List searchOrder(OrderVO orderVO) {
		
		List ls=this.orderDAO.searchOrder(orderVO);
		return ls;
	}

	@Override
	public List getOrderById(int id,String purchaseDate) {
		return this.orderDAO.getOrderById(id,purchaseDate);
	}

}
