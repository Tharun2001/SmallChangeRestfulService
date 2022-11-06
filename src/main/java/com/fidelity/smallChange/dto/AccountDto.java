package com.fidelity.smallChange.dto;

public class AccountDto {
	private String clientId;

	public AccountDto() {
		super();
	}

	public AccountDto(String clientId) {
		super();
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	
}
