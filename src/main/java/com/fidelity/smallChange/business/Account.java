package com.fidelity.smallChange.business;

import java.util.Objects;

public class Account {
	private String username;
	private String acct_num;
	private String type;
	
	public Account() {
		super();
	}

	public Account(String username, String acct_num, String type) {
		super();
		this.username = username;
		this.acct_num = acct_num;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAcct_num() {
		return acct_num;
	}

	public void setAcct_num(String acct_num) {
		this.acct_num = acct_num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acct_num, type, username);
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
		return Objects.equals(acct_num, other.acct_num) && Objects.equals(type, other.type)
				&& Objects.equals(username, other.username);
	}
	
}
