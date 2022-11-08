package com.fidelity.smallChange.dto;

import java.math.BigDecimal;

public class BankAccountDetailsDto {
	String bank_name;
	String account_number;
	BigDecimal balance;
	
	public BankAccountDetailsDto() {
		super();
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}
