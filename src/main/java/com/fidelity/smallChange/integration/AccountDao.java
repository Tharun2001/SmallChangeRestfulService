package com.fidelity.smallChange.integration;

import java.util.List;

import com.fidelity.smallChange.business.Account;

public interface AccountDao {
	Account getAccount(String username);
}
