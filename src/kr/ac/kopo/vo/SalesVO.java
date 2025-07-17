package kr.ac.kopo.vo;

import java.io.Serializable;

public class SalesVO implements Serializable {
	
	private String date;
	private int    seles;
	
	public SalesVO() {
		super();
	}
	
	public SalesVO(String date, int seles) {
		super();
		this.date = date;
		this.seles = seles;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSeles() {
		return seles;
	}

	public void setSeles(int seles) {
		this.seles = seles;
	}

}
