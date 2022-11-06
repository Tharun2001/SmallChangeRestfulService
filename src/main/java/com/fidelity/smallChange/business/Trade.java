package com.fidelity.smallChange.business;

import java.time.LocalDateTime;


public class Trade {
	private String trade_type;
	private Security security;
	private LocalDateTime trade_time;
	private double quantity;
	private double price;



	public Trade() {
		super();
	}

	public Trade(String trade_type, LocalDateTime trade_time, double quantity, double price) {
		super();
		this.trade_type = trade_type;
		this.trade_time = trade_time;
		this.quantity = quantity;
		this.price = price;
	}

	public Trade(String trade_type, Security security, LocalDateTime trade_time, double quantity, double price) {
		super();
		this.trade_type = trade_type;
		this.security = security;
		this.trade_time = trade_time;
		this.quantity = quantity;
		this.price = price;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public LocalDateTime getTrade_time() {
		return trade_time;
	}

	public void setTrade_time(LocalDateTime trade_time) {
		this.trade_time = trade_time;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
