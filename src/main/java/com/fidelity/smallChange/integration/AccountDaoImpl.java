package com.fidelity.smallChange.integration;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.Account;
import com.fidelity.smallChange.integration.mapper.AccountMapper;

@Repository
public class AccountDaoImpl implements AccountDao{
	@Autowired
	private AccountMapper mapper;
	
	@Override
	public Account getAccount(String username) {
		// TODO Auto-generated method stub
		return mapper.getAccount(username);
	}

	@Override
	public int createAccount(Account account) {
		// TODO Auto-generated method stub
		return mapper.createAccount(account);
	}

	@Override
	public int checkIfAccountExists(String clientId) {
		// TODO Auto-generated method stub
		return mapper.checkIfAccountExists(clientId);
	}

	@Override
	public BigDecimal getAccountFunds(String clientId) {
		// TODO Auto-generated method stub
		return mapper.getAccountFunds(clientId);
	}

	@Override
	public int updateFunds(String clientId, BigDecimal funds) {
		// TODO Auto-generated method stub
		return mapper.updateFunds(clientId, funds);
	}

	
}
