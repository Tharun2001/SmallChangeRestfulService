package com.fidelity.smallChange.business;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {
	private String clientId;
	private String account_number;
	private String bank_name;
	private BigDecimal balance;
	public BankAccount() {
		super();
	}
	public BankAccount(String clientId, String account_number, String bank_name, BigDecimal balance) {
		super();
		this.clientId = clientId;
		this.account_number = account_number;
		this.bank_name = bank_name;
		this.balance = balance;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(account_number, balance, bank_name, clientId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(account_number, other.account_number) && Objects.equals(balance, other.balance)
				&& Objects.equals(bank_name, other.bank_name) && Objects.equals(clientId, other.clientId);
	}
	@Override
	public String toString() {
		return "BankAccount [clientId=" + clientId + ", account_number=" + account_number + ", bank_name=" + bank_name
				+ ", balance=" + balance + "]";
	}

}
