package com.fidelity.smallChange.dto;

public class AccountDto {
	private String acctNum;

	public AccountDto() {
		super();
	}

	public AccountDto(String acctNum) {
		super();
		this.acctNum = acctNum;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	
	
}
