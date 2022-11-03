package com.fidelity.smallChange.business;

public class Preference {
	
	
	private String username;
	private String purpose;
	private int risk;
	private IncomeCategory incomeCategory;
	private int lengthOfInvestment;
	
	public Preference(String username, String purpose, int risk, IncomeCategory incomeCategory, int loi) {
		this.username = username;
		this.purpose = purpose;
		this.risk = risk;
		this.incomeCategory = incomeCategory;
		this.lengthOfInvestment = loi;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPurpose() {
		return purpose;
	}
	public int getRisk() {
		return risk;
	}
	public int getLengthOfInvestment() {
		return lengthOfInvestment;
	}
	public IncomeCategory getIncomeCategory() {
		return incomeCategory;
	}
}
