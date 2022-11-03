package com.fidelity.smallChange.dto;

public class SymbolFilterDto {
	private String acctNum;
	private String symbol;
	
	public SymbolFilterDto() {
		super();
	}

	public SymbolFilterDto(String acctNum, String symbol) {
		super();
		this.acctNum = acctNum;
		this.symbol = symbol;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "SymbolFilterDto [acctNum=" + acctNum + ", symbol=" + symbol + "]";
	}
	
	
}
