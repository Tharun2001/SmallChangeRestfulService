package com.fidelity.smallChange.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fidelity.smallChange.business.Security;

public class TradeDto {
	private String acct_num;
	private String trade_type;
	private double quantity;
	private double amount;
	private int s_id;
	
	public TradeDto() {
		super();
	}

	public TradeDto(String acct_num, String trade_type, double quantity, double amount, int s_id) {
		super();
		this.acct_num = acct_num;
		this.trade_type = trade_type;
		this.quantity = quantity;
		this.amount = amount;
		this.s_id = s_id;
	}

	public String getAcct_num() {
		return acct_num;
	}

	public void setAcct_num(String acct_num) {
		this.acct_num = acct_num;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	
}
