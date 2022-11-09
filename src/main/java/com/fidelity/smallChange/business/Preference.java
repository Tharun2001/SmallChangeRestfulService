package com.fidelity.smallChange.business;

import java.util.Objects;

public class Preference {
	private String username;
	private String purpose;
	private int risk;
	private String incomeCategory;
	private String lengthOfInvestment;
	
	public Preference(String username, String purpose, int risk, String incomeCategory, String lengthOfInvestment) {
		this.username = username;
		this.purpose = purpose;
		this.risk = risk;
		this.incomeCategory = incomeCategory;
		this.lengthOfInvestment = lengthOfInvestment;
	}
	
	@Override
	public String toString() {
		return "Preference [username=" + username + ", purpose=" + purpose + ", risk=" + risk + ", incomeCategory="
				+ incomeCategory + ", lengthOfInvestment=" + lengthOfInvestment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(incomeCategory, lengthOfInvestment, purpose, risk, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preference other = (Preference) obj;
		return Objects.equals(incomeCategory, other.incomeCategory)
				&& Objects.equals(lengthOfInvestment, other.lengthOfInvestment)
				&& Objects.equals(purpose, other.purpose) && risk == other.risk
				&& Objects.equals(username, other.username);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	public void setIncomeCategory(String incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	public void setLengthOfInvestment(String lengthOfInvestment) {
		this.lengthOfInvestment = lengthOfInvestment;
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
	public String getLengthOfInvestment() {
		return lengthOfInvestment;
	}
	public String getIncomeCategory() {
		return incomeCategory;
	}
}
