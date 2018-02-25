package com.tsy.cl.main.gclass.bena;

public class GclassBean {
	
	private int gclass_id;
	
	private String gclass_name;

	public int getGclass_id() {
		return gclass_id;
	}

	public void setGclass_id(int gclass_id) {
		this.gclass_id = gclass_id;
	}

	public String getGclass_name() {
		return gclass_name;
	}

	public void setGclass_name(String gclass_name) {
		this.gclass_name = gclass_name;
	}

	public GclassBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GclassBean(int gclass_id, String gclass_name) {
		super();
		this.gclass_id = gclass_id;
		this.gclass_name = gclass_name;
	}

	public GclassBean(String gclass_name) {
		super();
		this.gclass_name = gclass_name;
	}
	
	
	
	

}
