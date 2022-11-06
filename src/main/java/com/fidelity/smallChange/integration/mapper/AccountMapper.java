package com.fidelity.smallChange.integration.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fidelity.smallChange.business.Account;

@Mapper
public interface AccountMapper {
	Account getAccount(String username);
	int createAccount(Account acct);
	int checkIfAccountExists(String clientId);
	
	BigDecimal getAccountFunds(String clientId);
	int updateFunds(@Param("clientId") String clientId,@Param("funds") BigDecimal funds);
}
