package com.fidelity.smallChange.business;

import java.util.Objects;

public class Holding {
	private int sId;
	private Security security;
	private double holdingQuantity;
	private double investedAmount;
	
	public Holding() {
		super();
	}

	public Holding(int sId, double holdingQuantity, double investedAmount) {
		super();
		this.sId = sId;
		this.holdingQuantity = holdingQuantity;
		this.investedAmount = investedAmount;
	}
	
	public Holding(int sId, Security security, double holdingQuantity, double investedAmount) {
		super();
		this.sId = sId;
		this.security = security;
		this.holdingQuantity = holdingQuantity;
		this.investedAmount = investedAmount;
	}

	
	public int getsId() {
		return sId;
	}
	
	public void setsId(int sId) {
		this.sId = sId;
	}
	public Security getSecurity() {
		return security;
	}
	
	public void setSecurity(Security security) {
		this.security = security;
	}
	
	public double getHoldingQuantity() {
		return holdingQuantity;
	}
	
	public void setHoldingQuantity(double holdingQuantity) {
		this.holdingQuantity = holdingQuantity;
	}
	
	public double getInvestedAmount() {
		return investedAmount;
	}
	
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(holdingQuantity, investedAmount, sId, security);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Holding other = (Holding) obj;
		return Double.doubleToLongBits(holdingQuantity) == Double.doubleToLongBits(other.holdingQuantity)
				&& Double.doubleToLongBits(investedAmount) == Double.doubleToLongBits(other.investedAmount)
				&& sId == other.sId && Objects.equals(security, other.security);
	}

	@Override
	public String toString() {
		return "Holding [sId=" + sId + ", security=" + security + ", holdingQuantity="
				+ holdingQuantity + ", investedAmount=" + investedAmount + "]";
	}
	
	

}
