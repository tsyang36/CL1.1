package com.tsy.cl.main.addr.bena;

public class AddrBean {
	private int addr_id;
	private String addr_name;
	private String addr_province;
	private String addr_city;
	private String addr_district;
	private String addrxx;
	private String tel;
	private String youbian;
	private int user_id;
	public int getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "AddrBean [addr_id=" + addr_id + ", addr_name=" + addr_name + ", addr_province=" + addr_province
				+ ", addr_city=" + addr_city + ", addr_district=" + addr_district + ", addrxx=" + addrxx + ", tel="
				+ tel + ", youbian=" + youbian + ", user_id=" + user_id + "]";
	}
	public AddrBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddrBean(int addr_id, String addr_name, String addr_province, String addr_city, String addr_district,
			String addrxx, String tel, String youbian, int user_id) {
		super();
		this.addr_id = addr_id;
		this.addr_name = addr_name;
		this.addr_province = addr_province;
		this.addr_city = addr_city;
		this.addr_district = addr_district;
		this.addrxx = addrxx;
		this.tel = tel;
		this.youbian = youbian;
		this.user_id = user_id;
	}
	public AddrBean(String addr_name, String addr_province, String addr_city, String addr_district, String addrxx,
			String tel, String youbian, int user_id) {
		super();
		this.addr_name = addr_name;
		this.addr_province = addr_province;
		this.addr_city = addr_city;
		this.addr_district = addr_district;
		this.addrxx = addrxx;
		this.tel = tel;
		this.youbian = youbian;
		this.user_id = user_id;
	}
	
	
	
}
