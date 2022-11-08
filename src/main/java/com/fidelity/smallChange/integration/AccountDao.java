package com.fidelity.smallChange.integration;

import java.math.BigDecimal;
import java.util.List;

import com.fidelity.smallChange.business.Account;

public interface AccountDao {
	Account getAccount(String username);
	int createAccount(Account acct);
	int checkIfAccountExists(String clientId);
	
	BigDecimal getAccountFunds(String clientId);
	int updateFunds(String clientId, BigDecimal funds);
}
