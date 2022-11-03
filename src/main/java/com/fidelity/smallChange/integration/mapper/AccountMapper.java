package com.fidelity.smallChange.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fidelity.smallChange.business.Account;

@Mapper
public interface AccountMapper {
	Account getAccount(String username);
}
