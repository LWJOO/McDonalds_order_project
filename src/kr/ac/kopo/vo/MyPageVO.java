package kr.ac.kopo.vo;

import java.io.Serializable;

public class MyPageVO implements Serializable {
	
	private String menu_name;
	private int    total_qty;
	
	public MyPageVO() {
		super();
	}
	
	public MyPageVO(String menu_name, int total_qty) {
		super();
		this.menu_name = menu_name;
		this.total_qty = total_qty;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getTotal_qty() {
		return total_qty;
	}

	public void setTotal_qty(int total_qty) {
		this.total_qty = total_qty;
	}
	
	

}
