package com.fidelity.smallChange.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fidelity.smallChange.business.Security;

public class TradeDto {
	private String clientId;
	private String trade_type;
	private double quantity;
	private double price;
	private int s_id;
	
	public TradeDto() {
		super();
	}

	public TradeDto(String clientId, String trade_type, double quantity, double price, int s_id) {
		super();
		this.clientId = clientId;
		this.trade_type = trade_type;
		this.quantity = quantity;
		this.price = price;
		this.s_id = s_id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
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

	public void setAmount(double amount) {
		this.price = price;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	
}
