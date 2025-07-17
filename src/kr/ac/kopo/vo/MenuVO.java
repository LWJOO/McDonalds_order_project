package kr.ac.kopo.vo;

import java.io.Serializable;

public class MenuVO implements Serializable {
	
	private int    menu_no;
	private String menu_name;
	private String menu_type;
	private int    menu_price;
	
	public MenuVO() {
		super();
	}
	
	public MenuVO(String menu_name, int menu_price) {
		super();
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}
	
	public int getMenu_no() {
		return menu_no;
	}

	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
	}


	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}

	@Override
	public String toString() {
		return "BoardVO [menu_name=" + menu_name + ", menu_type=" + menu_type + ", menu_price=" + menu_price + "]";
	}
}
