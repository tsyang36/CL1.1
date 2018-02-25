package com.tsy.cl.main.user.bena;

public class UserBean {
	
	private int user_id;
	
	private String user_tel;
	
	private String user_email;
	
	private String user_password;

	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", user_tel=" + user_tel + ", user_email=" + user_email
				+ ", user_password=" + user_password + "]";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean(int user_id, String user_tel, String user_email, String user_password) {
		super();
		this.user_id = user_id;
		this.user_tel = user_tel;
		this.user_email = user_email;
		this.user_password = user_password;
	}

	public UserBean(String user_tel, String user_email, String user_password) {
		super();
		this.user_tel = user_tel;
		this.user_email = user_email;
		this.user_password = user_password;
	}
	
	

}
