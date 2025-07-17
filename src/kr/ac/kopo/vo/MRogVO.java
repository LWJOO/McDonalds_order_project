package kr.ac.kopo.vo;

import java.io.Serializable;

public class MRogVO implements Serializable {
	
	private int    master_no;
	private String master_id;
	private String master_pw;
	
	public MRogVO() {
		super();
	}
	
	public MRogVO(String master_id, String master_pw) {
		super();
		this.master_id = master_id;
		this.master_pw = master_pw;
	}
	
	public int getMaster_no() {
		return master_no;
	}

	public void setMaster_no(int master_no) {
		this.master_no = master_no;
	}


	public String getMaster_id() {
		return master_id;
	}


	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}


	public String getMaster_pw() {
		return master_pw;
	}


	public void setMaster_pw(String master_pw) {
		this.master_pw = master_pw;
	}

	@Override
	public String toString() {
		return "MRogVO [master_no=" + master_no + ", master_id=" + master_id + ", master_pw=" + master_pw + "]";
	}
	
	

}
