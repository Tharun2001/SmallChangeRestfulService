package com.fidelity.smallChange.business;

import java.util.Objects;

public class Security {
	private int sid;
	private String sname; 
	private String scode;
	private double ltp;
	private String assetClass;
	
	public Security() {
		super();
	}
	
	public Security(int sid) {
		super();
		this.sid = sid;
	}

	public Security(int sid, String sname,  String scode,double ltp, String assetClass) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.ltp = ltp;
		this.scode = scode;
		this.assetClass = assetClass;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getLtp() {
		return ltp;
	}
	public void setLtp(double ltp) {
		this.ltp = ltp;
	}
	public String getScode() {
		return scode;
	}
	
	public void setScode(String scode) {
		this.scode = scode;
	}
	
	public String getAssetClass() {
		return assetClass;
	}
	
	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}
	
	@Override
	public String toString() {
		return "Security [sid=" + sid + ", sname=" + sname + ", ltp=" + ltp + ", scode=" + scode + ", assetClass="
				+ assetClass + "]";
	}
	
	

}
