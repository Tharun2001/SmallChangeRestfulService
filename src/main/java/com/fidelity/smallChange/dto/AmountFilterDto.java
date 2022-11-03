package com.fidelity.smallChange.dto;

public class AmountFilterDto {
	String acctNum;
	double startAmt;
	double endAmt;
	
	public AmountFilterDto() {
		super();
	}
	public AmountFilterDto(String acctNum, double startAmt, double endAmt) {
		super();
		this.acctNum = acctNum;
		this.startAmt = startAmt;
		this.endAmt = endAmt;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
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
		return "AmountFilterDto [acctNum=" + acctNum + ", startAmt=" + startAmt + ", endAmt=" + endAmt + "]";
	}
	
	
	
}
