package com.fidelity.smallChange.integration;

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

	
}
