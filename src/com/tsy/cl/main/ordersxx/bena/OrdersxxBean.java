package com.tsy.cl.main.ordersxx.bena;

import java.math.BigDecimal;

public class OrdersxxBean {
	
	private int ordersxx_id;
	
	private int goods_id;
	
	private int orders_id;
	
	private int goods_number;
	
	

	@Override
	public String toString() {
		return "OrdersxxBean [ordersxx_id=" + ordersxx_id + ", goods_id=" + goods_id + ", orders_id=" + orders_id
				+ ", goods_number=" + goods_number + "]";
	}

	public int getOrdersxx_id() {
		return ordersxx_id;
	}

	public void setOrdersxx_id(int ordersxx_id) {
		this.ordersxx_id = ordersxx_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public int getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public OrdersxxBean(int ordersxx_id, int goods_id, int orders_id, int goods_number) {
		super();
		this.ordersxx_id = ordersxx_id;
		this.goods_id = goods_id;
		this.orders_id = orders_id;
		this.goods_number = goods_number;
	}

	public OrdersxxBean(int goods_id, int orders_id, int goods_number) {
		super();
		this.goods_id = goods_id;
		this.orders_id = orders_id;
		this.goods_number = goods_number;
	}

	public OrdersxxBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
