package com.fidelity.smallChange.integration;

import java.math.BigDecimal;
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
	public List<BankAccount> getBankAccounts(String clientId) {
		// TODO Auto-generated method stub
		return mapper.getBankAccounts(clientId);
	}

	@Override
	public int insertBankAccount(BankAccount acct) {
		return mapper.insertBankAccount(acct);	
	}

	@Override
	public int updateBankAccount(BankAccount acct) {
		return mapper.updateBankAccount(acct);
		
	}

	@Override
	public int deleteBankAccount(String acctnum) {
		return mapper.deleteBankAccount(acctnum);
		
	}

	@Override
	public BigDecimal getBankBalance(String acct_num) {
		// TODO Auto-generated method stub
		return mapper.getBankBalance(acct_num);
	}

	@Override
	public int updateBankBalance(String acct_num, BigDecimal amt) {
		// TODO Auto-generated method stub
		return mapper.updateBankBalance(acct_num, amt);
	}
}
