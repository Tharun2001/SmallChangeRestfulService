package com.fidelity.smallChange.dto;

import java.time.LocalDateTime;

public class HoldingDto {
	private int sid;
	private String name;
	private String code;
	private double quantity;
	private double invested_amount;
	private double ltp;
	private String asset_class;
	

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getInvested_amount() {
		return invested_amount;
	}
	public void setInvested_amount(double invested_amount) {
		this.invested_amount = invested_amount;
	}
	public String getAsset_class() {
		return asset_class;
	}
	public void setAsset_class(String asset_class) {
		this.asset_class = asset_class;
	}

	public double getLtp() {
		return ltp;
	}
	public void setLtp(double ltp) {
		this.ltp = ltp;
	}
}
