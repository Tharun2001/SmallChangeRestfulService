package com.fidelity.smallChange.integration;

import java.util.List;
import com.fidelity.smallChange.business.BankAccount;

public interface BankAccountDao {
	List<BankAccount> getBankAccounts(String acctnum);
	void insertBankAccount(BankAccount acct);
	void updateBankAccount(BankAccount acct);
	void deleteBankAccount(String acctnum);
}
