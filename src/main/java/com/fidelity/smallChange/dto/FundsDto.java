package com.fidelity.smallChange.dto;

import java.math.BigDecimal;

public class FundsDto {
	private String clientId;
	private String account_number;
	private BigDecimal amount;
	
	public FundsDto() {
		super();
	}

	public FundsDto(String clientId, String account_number, BigDecimal amount) {
		super();
		this.clientId = clientId;
		this.account_number = account_number;
		this.amount = amount;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
