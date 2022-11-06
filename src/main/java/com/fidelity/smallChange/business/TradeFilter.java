package com.fidelity.smallChange.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TradeFilter {
private String clientId;
	
	private List<String> symbol;
	
	private List<String> asset_class;
	private String side;
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	private double startAmt;
	private double endAmt;
	
	
	public TradeFilter() {
		super();
	}


	public TradeFilter(String clientId, List<String> symbol, List<String> asset_class, String side,
			LocalDateTime startDate, LocalDateTime endDate, double startAmt, double endAmt) {
		super();
		this.clientId = clientId;
		this.symbol = symbol;
		this.asset_class = asset_class;
		this.side = side;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startAmt = startAmt;
		this.endAmt = endAmt;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public List<String> getSymbol() {
		return symbol;
	}


	public void setSymbol(List<String> symbol) {
		this.symbol = symbol;
	}


	public List<String> getAsset_class() {
		return asset_class;
	}


	public void setAsset_class(List<String> asset_class) {
		this.asset_class = asset_class;
	}


	public String getSide() {
		return side;
	}


	public void setSide(String side) {
		this.side = side;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public double getStartAmt() {
		return startAmt;
	}


	public void setStartAmt(double startAmt) {
		this.startAmt = startAmt;
	}


	public double getEndAmt() {
		return endAmt;
	}


	public void setEndAmt(double endAmt) {
		this.endAmt = endAmt;
	}


	@Override
	public String toString() {
		return "TradeFilter [clientId=" + clientId + ", symbol=" + symbol + ", asset_class=" + asset_class + ", side="
				+ side + ", startDate=" + startDate + ", endDate=" + endDate + ", startAmt=" + startAmt + ", endAmt="
				+ endAmt + "]";
	}
	
}
