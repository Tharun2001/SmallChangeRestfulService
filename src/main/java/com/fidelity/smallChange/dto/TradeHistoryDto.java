package com.fidelity.smallChange.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TradeHistoryDto {
	private String name;
	private String code;
	private double quantity;
	private double price;
	private String asset_class;
	private String trade_type;
	private LocalDateTime date;
	
	public TradeHistoryDto() {
		super();
	}

	public TradeHistoryDto(String name, String code, double quantity, double price, String asset_class,
			String trade_type, LocalDateTime date) {
		super();
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.price = price;
		this.asset_class = asset_class;
		this.trade_type = trade_type;
		this.date = date;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAsset_class() {
		return asset_class;
	}

	public void setAsset_class(String asset_class) {
		this.asset_class = asset_class;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
