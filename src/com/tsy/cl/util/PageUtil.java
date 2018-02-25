package com.tsy.cl.util;

public class PageUtil {
	//��ǰҳ
	private int current;
	//�ܼ�¼��
	private int totalRow;
	//��ҳ��
	private int pagetnum;
	//ÿҳ���ټ�¼
	private int size =9;
	//&auser=
	private String param;
	
	public int getbegin(){
		return (current-1)*size;
	}
	
	
	
	public PageUtil(int current, int totalRow, String param) {
		
		//��ҳ��
		int pagetnum=totalRow%size==0?totalRow/size:totalRow/size+1;
		if(pagetnum<1){
			pagetnum=1;
		}
		//��ȡ��ǰҳ
		if(current<1){
			current=1;
		}else if(current>pagetnum){
			current=pagetnum;
		}
		this.current = current;
		this.totalRow = totalRow;
		this.param = param;
		this.pagetnum = pagetnum;
	}



	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	public int getPagenum() {
		return pagetnum;
	}
	public void setPagenum(int pagenum) {
		this.pagetnum = pagenum;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}



	@Override
	public String toString() {
		return "PageUtil [current=" + current + ", totalRow=" + totalRow + ", pagetnum=" + pagetnum + ", size=" + size
				+ ", param=" + param + "]";
	}
	
}
