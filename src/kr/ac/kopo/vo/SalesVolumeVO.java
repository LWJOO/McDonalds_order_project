package kr.ac.kopo.vo;

import java.io.Serializable;

public class SalesVolumeVO implements Serializable {
	
	private String menu_name;
	private String menu_type;
	private int    sum_sales;
	
	public SalesVolumeVO() {
		super();
	}
	
	public SalesVolumeVO(String menu_name, String menu_type, int sum_sales) {
		super();
		this.menu_name = menu_name;
		this.menu_type = menu_type;
		this.sum_sales = sum_sales;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getSum_sales() {
		return sum_sales;
	}

	public void setSum_sales(int sum_sales) {
		this.sum_sales = sum_sales;
	}

	public String getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}
	
	

}
