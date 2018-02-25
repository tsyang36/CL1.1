package com.tsy.cl.main.admin.bean;
/**
 * 
 * @Title: AdminBean.java
 * @Package com.zrycx.millet.admin.admin.bean
 * @Description: TODO
 * @author Tang
 * @date 2017年8月16日 下午3:36:00
 * @version 1.0
 */
public class AdminBean {
	private int admin_id;
	private String admin_tel;
	private String admin_email;
	private String admin_password;
	private String admin_state;
	private int role_id;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_tel() {
		return admin_tel;
	}
	public void setAdmin_tel(String admin_tel) {
		this.admin_tel = admin_tel;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_state() {
		return admin_state;
	}
	public void setAdmin_state(String admin_state) {
		this.admin_state = admin_state;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "AdminBean [admin_id=" + admin_id + ", admin_tel=" + admin_tel + ", admin_email=" + admin_email
				+ ", admin_password=" + admin_password + ", admin_state=" + admin_state + ", role_id=" + role_id + "]";
	}
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminBean(String admin_tel, String admin_email, String admin_password, String admin_state, int role_id) {
		this.admin_tel = admin_tel;
		this.admin_email = admin_email;
		this.admin_password = admin_password;
		this.admin_state = admin_state;
		this.role_id = role_id;
	}
	public AdminBean(int admin_id, String admin_tel, String admin_email, String admin_password, String admin_state,
			int role_id) {
		this.admin_id = admin_id;
		this.admin_tel = admin_tel;
		this.admin_email = admin_email;
		this.admin_password = admin_password;
		this.admin_state = admin_state;
		this.role_id = role_id;
	}
	
}
