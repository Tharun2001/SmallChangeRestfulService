package com.fidelity.smallChange.dto;

public class BankAccountDto {
	private String clientId;
	private String account_number;
	
	public BankAccountDto() {
		super();
	}

	public BankAccountDto(String clientId, String account_number) {
		super();
		this.clientId = clientId;
		this.account_number = account_number;
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
	
	
}
