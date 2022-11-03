package com.fidelity.smallChange.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.BankAccount;
import com.fidelity.smallChange.integration.mapper.BankAccountMapper;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@Autowired
	private BankAccountMapper mapper;

	@Override
	public List<BankAccount> getBankAccounts(String acctnum) {
		// TODO Auto-generated method stub
		return mapper.getBankAccounts(acctnum);
	}

	@Override
	public void insertBankAccount(BankAccount acct) {
		mapper.insertBankAccount(acct);	
	}

	@Override
	public void updateBankAccount(BankAccount acct) {
		mapper.updateBankAccount(acct);
		
	}

	@Override
	public void deleteBankAccount(String acctnum) {
		mapper.deleteBankAccount(acctnum);
		
	}
}
