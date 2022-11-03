package com.fidelity.smallChange.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fidelity.smallChange.business.BankAccount;

@Mapper
public interface BankAccountMapper {
	List<BankAccount> getBankAccounts(String acctnum);
	void insertBankAccount(BankAccount acct);
	void updateBankAccount(BankAccount acct);
	void deleteBankAccount(String acctnum);
}
