package com.whhp.entity;

public class HouseExt extends House {
	private String sname;
	private String dname;
	private String tname;
	private Integer distrctid;

	public Integer getDistrctid() {
		return distrctid;
	}

	public void setDistrctid(Integer distrctid) {
		this.distrctid = distrctid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
}
