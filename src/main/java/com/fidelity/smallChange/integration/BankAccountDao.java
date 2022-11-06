package com.fidelity.smallChange.integration;

import java.math.BigDecimal;
import java.util.List;
import com.fidelity.smallChange.business.BankAccount;

public interface BankAccountDao {
	List<BankAccount> getBankAccounts(String clientId);
	int insertBankAccount(BankAccount acct);
	int updateBankAccount(BankAccount acct);
	int deleteBankAccount(String acctnum);
	
	BigDecimal getBankBalance(String acct_num);
	int updateBankBalance(String acct_num, BigDecimal amt);
}
