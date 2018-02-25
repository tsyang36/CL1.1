package com.tsy.cl.main.menu.bean;

import java.util.List;


/**
 * 
 * @Title: MenuBean.java
 * @Package com.zrcx.millet.admin.menu.bean
 * @Description: 鑿滃崟瀹炰綋绫�
 * @author Xiao_Ming Liu
 * @date 2017骞�8鏈�21鏃� 涓嬪崍4:42:24
 * @version 1.0
 */
public class MenuBean {

	private  int menu_id;

	private String menu_name;

	private String menu_url;

	private int father_id;
	
	private List<MenuBean> list;

	public int getMenu_id() {
		return menu_id;
	}

	public MenuBean(String menu_name, String menu_url, int father_id) {
		super();
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.father_id = father_id;
	}

	public MenuBean(int menu_id, String menu_name, String menu_url, int father_id) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.father_id = father_id;
	}

	public MenuBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	public int getFather_id() {
		return father_id;
	}

	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}

	public List<MenuBean> getList() {
		return list;
	}

	public void setList(List<MenuBean> list) {
		this.list = list;
	}

	



}
