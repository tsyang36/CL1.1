package com.tsy.cl.main.car.bean;

import com.tsy.cl.main.goods.bean.GoodsBean;

public class CarBean {
	
	private int car_id;
	
	private int user_id;
	
	private int goods_id;
	
	private int goods_number;
	
	private GoodsBean goodsBean;

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public GoodsBean getGoodsBean() {
		return goodsBean;
	}

	public void setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
	}

	@Override
	public String toString() {
		return "CarBean [car_id=" + car_id + ", user_id=" + user_id + ", goods_id=" + goods_id + ", goods_number="
				+ goods_number + "]";
	}

	public CarBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarBean(int car_id, int user_id, int goods_id, int goods_number) {
		super();
		this.car_id = car_id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.goods_number = goods_number;
	}

	public CarBean(int user_id, int goods_id, int goods_number) {
		super();
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.goods_number = goods_number;
	}
	

	
	

}
