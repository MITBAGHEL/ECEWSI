package com.ecewsi.dao;

import java.util.List;

import com.ecewsi.model.OrderVO;

public interface OrderDAO {
	public List searchOrder(OrderVO oredrVO);

	public List getOrderById(int id, String purchaseDate);
}
