package com.fidelity.smallChange.service;

import java.math.BigDecimal;

import com.fidelity.smallChange.business.User;

public interface AccountService {
	int registerUser(User user);
	boolean checkIfAccountExists(String clientId);
	void addFunds(String clientId, String acct_num, BigDecimal amount) throws Exception;
	void withdrawFunds(String clientId, String acct_num, BigDecimal amount) throws Exception;	
}
