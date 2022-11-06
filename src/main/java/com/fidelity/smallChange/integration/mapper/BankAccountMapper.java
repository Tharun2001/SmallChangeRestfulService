package com.fidelity.smallChange.integration.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fidelity.smallChange.business.BankAccount;

@Mapper
public interface BankAccountMapper {
	List<BankAccount> getBankAccounts(String clientId);
	int insertBankAccount(BankAccount acct);
	int updateBankAccount(BankAccount acct);
	int deleteBankAccount(String acct_num);
	BigDecimal getBankBalance(String acct_num);
	int updateBankBalance(@Param("account_number") String acct_num, @Param("balance") BigDecimal balance);
}
