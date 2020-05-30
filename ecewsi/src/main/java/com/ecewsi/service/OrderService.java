package com.ecewsi.service;

import java.util.List;

import com.ecewsi.model.OrderVO;

public interface OrderService {
		public List searchOrder(OrderVO orderVO);

		public List getOrderById(int id, String purchaseDate);
}
