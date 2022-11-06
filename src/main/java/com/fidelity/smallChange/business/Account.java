package com.fidelity.smallChange.business;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
	private String username;
	private String clientId;
	private BigDecimal funds;
	
	public Account() {
		super();
	}

	public Account(String clientId, BigDecimal funds) {
		super();
		this.clientId = clientId;
		this.funds = funds;
	}

	public Account(String username, String clientId, BigDecimal funds) {
		super();
		this.username = username;
		this.clientId = clientId;
		this.funds = funds;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getFunds() {
		return funds;
	}

	public void setFunds(BigDecimal funds) {
		this.funds = funds;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, funds, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(funds, other.funds)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", clientId=" + clientId + ", funds=" + funds + "]";
	}


	
	
	
	
	
}
