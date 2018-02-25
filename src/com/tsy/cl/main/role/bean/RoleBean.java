package com.tsy.cl.main.role.bean;

public class RoleBean {
	private int role_id;
	private String role_name;
	private String role_state;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_state() {
		return role_state;
	}
	public void setRole_state(String role_state) {
		this.role_state = role_state;
	}
	@Override
	public String toString() {
		return "RoleBean [role_id=" + role_id + ", role_name=" + role_name + ", role_state=" + role_state + "]";
	}
	public RoleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleBean(int role_id, String role_name, String role_state) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_state = role_state;
	}
	public RoleBean(String role_name, String role_state) {
		super();
		this.role_name = role_name;
		this.role_state = role_state;
	}
	
	
	
}
