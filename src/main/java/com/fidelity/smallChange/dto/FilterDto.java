package com.fidelity.smallChange.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FilterDto {
	private String clientId;
	
	private List<String> symbol;
	
	private List<String> asset_class;
	private String side;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate endDate;
	
	private double startAmt;
	private double endAmt;
	
	
	public FilterDto() {
		super();
	}
	public FilterDto(String clientId, List<String> symbol, List<String> asset_class, String side, LocalDate startDate,
			LocalDate endDate, double startAmt, double endAmt) {
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
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
		return "FilterDto [clientId=" + clientId + ", symbol=" + symbol + ", asset_class=" + asset_class + ", side="
				+ side + ", startDate=" + startDate + ", endDate=" + endDate + ", startAmt=" + startAmt + ", endAmt="
				+ endAmt + "]";
	}
	
	
}
