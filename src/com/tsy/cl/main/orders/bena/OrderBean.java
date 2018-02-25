package com.tsy.cl.main.orders.bena;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.tsy.cl.main.goods.bean.GoodsBean;



public class OrderBean {
	
	private int order_id;
	
	private String order_code;
	
	private Timestamp order_time;
	
	private String  order_state;
	
	private int user_id;
	
	//orderxx
	private int goods_number;
	//addr
	private String addr_name;
	private String addr_province;
	private String addr_city;
	private String addr_district;
	private String addrxx;
	private String tel;
	private String youbian;
	//goods
	private String goods_name;

	private BigDecimal orders_sumprice;
	
	private List<GoodsBean> goodsBeans;
	
	public List<GoodsBean> getGoodsBeans() {
		return goodsBeans;
	}

	
	public OrderBean(int order_id, String order_code, Timestamp order_time, String order_state, int user_id,
			 int goods_number, String addr_name, String addr_province, String addr_city,
			String addr_district, String addrxx, String tel, String youbian, String goods_name) {
		super();
		this.order_id = order_id;
		this.order_code = order_code;
		this.order_time = order_time;
		this.order_state = order_state;
		this.user_id = user_id;
		
		this.goods_number = goods_number;
		this.addr_name = addr_name;
		this.addr_province = addr_province;
		this.addr_city = addr_city;
		this.addr_district = addr_district;
		this.addrxx = addrxx;
		this.tel = tel;
		this.youbian = youbian;
		this.goods_name = goods_name;
		//this.orders_sumprice = orders_sumprice;
	}


	public OrderBean(String order_code, Timestamp order_time, String order_state, int user_id,
			int goods_number, String addr_name, String addr_province, String addr_city, String addr_district,
			String addrxx, String tel, String youbian, String goods_name) {
		super();
		this.order_code = order_code;
		this.order_time = order_time;
		this.order_state = order_state;
		this.user_id = user_id;
		this.goods_number = goods_number;
		this.addr_name = addr_name;
		this.addr_province = addr_province;
		this.addr_city = addr_city;
		this.addr_district = addr_district;
		this.addrxx = addrxx;
		this.tel = tel;
		this.youbian = youbian;
		this.goods_name = goods_name;
	}


	public int getGoods_number() {
		return goods_number;
	}


	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}


	public String getAddr_name() {
		return addr_name;
	}


	public void setAddr_name(String addr_name) {
		this.addr_name = addr_name;
	}


	public String getAddr_province() {
		return addr_province;
	}


	public void setAddr_province(String addr_province) {
		this.addr_province = addr_province;
	}


	public String getAddr_city() {
		return addr_city;
	}


	public void setAddr_city(String addr_city) {
		this.addr_city = addr_city;
	}


	public String getAddr_district() {
		return addr_district;
	}


	public void setAddr_district(String addr_district) {
		this.addr_district = addr_district;
	}


	public String getAddrxx() {
		return addrxx;
	}


	public void setAddrxx(String addrxx) {
		this.addrxx = addrxx;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getYoubian() {
		return youbian;
	}


	public void setYoubian(String youbian) {
		this.youbian = youbian;
	}


	public String getGoods_name() {
		return goods_name;
	}


	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}


	public void setGoodsBeans(List<GoodsBean> goodsBeans) {
		this.goodsBeans = goodsBeans;
	}


	public Timestamp getOrder_time() {
		return order_time;
	}


	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}


	public BigDecimal getOrders_sumprice() {
		return orders_sumprice;
	}


	public void setOrders_sumprice(BigDecimal orders_sumprice) {
		this.orders_sumprice = orders_sumprice;
	}

	@Override
	public String toString() {
		return "OrderBean [order_id=" + order_id + ", order_code=" + order_code + ", order_time=" + order_time
				+ ", order_state=" + order_state + ", user_id=" + user_id + ", goods_number=" + goods_number
				+ ", addr_name=" + addr_name + ", addr_province=" + addr_province + ", addr_city=" + addr_city
				+ ", addr_district=" + addr_district + ", addrxx=" + addrxx + ", tel=" + tel + ", youbian=" + youbian
				+ ", goods_name=" + goods_name + ", orders_sumprice=" + orders_sumprice + ", goodsBeans=" + goodsBeans
				+ "]";
	}


	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_code() {
		return order_code;
	}

	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}


	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public OrderBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderBean(int order_id, String order_code, Timestamp order_time, String order_state, int user_id,
			String addr_name, String addr_province, String addr_city, String addr_district, String addrxx, String tel,
			String youbian, BigDecimal orders_sumprice) {
		super();
		this.order_id = order_id;
		this.order_code = order_code;
		this.order_time = order_time;
		this.order_state = order_state;
		this.user_id = user_id;
		this.addr_name = addr_name;
		this.addr_province = addr_province;
		this.addr_city = addr_city;
		this.addr_district = addr_district;
		this.addrxx = addrxx;
		this.tel = tel;
		this.youbian = youbian;
		this.orders_sumprice = orders_sumprice;
	}


	



	

	
	
	
	
}
