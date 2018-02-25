package com.tsy.cl.main.goods.bean;

import java.math.BigDecimal;

public class GoodsBean {
	
	private int goods_id;
	
	private String goods_name;
	
	private String goods_image;
	
	private BigDecimal goods_price;
	
	private String goods_desc;
	
	private int gclassId;
	//-----------------
	private int goods_number;
	
	private BigDecimal goods_sumprice;
	
	public int getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public BigDecimal getGoods_sumprice() {
		return goods_sumprice;
	}

	public void setGoods_sumprice(BigDecimal goods_sumprice) {
		this.goods_sumprice = goods_sumprice;
	}

	@Override
	public String toString() {
		return "GoodsBean [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_image=" + goods_image
				+ ", goods_price=" + goods_price + ", goods_desc=" + goods_desc + ", gclassId=" + gclassId + "]";
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public BigDecimal getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(BigDecimal goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public int getGclassId() {
		return gclassId;
	}

	public void setGclassId(int gclassId) {
		this.gclassId = gclassId;
	}

	public GoodsBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsBean(int goods_id, String goods_name, String goods_image, BigDecimal goods_price, String goods_desc,
			int gclassId) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_image = goods_image;
		this.goods_price = goods_price;
		this.goods_desc = goods_desc;
		this.gclassId = gclassId;
	}

	public GoodsBean(String goods_name, String goods_image, BigDecimal goods_price, String goods_desc, int gclassId) {
		super();
		this.goods_name = goods_name;
		this.goods_image = goods_image;
		this.goods_price = goods_price;
		this.goods_desc = goods_desc;
		this.gclassId = gclassId;
	}

	
	
	
}
