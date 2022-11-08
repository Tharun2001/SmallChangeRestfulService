package com.fidelity.smallChange.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.Account;
import com.fidelity.smallChange.integration.AccountDao;
import com.fidelity.smallChange.integration.BankAccountDao;

@SpringBootTest
@Transactional
class AccountServiceImplTest {
	@Autowired
	BankAccountDao bankAccountDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	AccountServiceImpl service;
	
	@Test
	void testGenerateClientId() {
		String clientId1 = service.generateClientId();
		String clientId2 = service.generateClientId();
		
		assertEquals(clientId1.length(), 6);
		assertNotEquals(clientId1, clientId2);
	}
	
	
	@Test
	void checkAddFunds() {
		BigDecimal amt = BigDecimal.valueOf(1000);
		BigDecimal oldFunds = accountDao.getAccountFunds("ABC123");
		BigDecimal oldBalance = bankAccountDao.getBankBalance("608502111");
		
		
		try {
			service.addFunds("ABC123", "608502111", amt);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BigDecimal balance = bankAccountDao.getBankBalance("608502111");
		BigDecimal funds = accountDao.getAccountFunds("ABC123");
		
		assertTrue(funds.compareTo(oldFunds.add(amt)) == 0);
		assertTrue(balance.compareTo(oldBalance.subtract(amt)) == 0);
		
	}

	@Test
	void checkwithDrawFunds() {
		BigDecimal amt = BigDecimal.valueOf(1000);
		BigDecimal oldFunds = accountDao.getAccountFunds("ABC123");
		BigDecimal oldBalance = bankAccountDao.getBankBalance("608502111");
		
		
		try {
			service.withdrawFunds("ABC123", "608502111", amt);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BigDecimal balance = bankAccountDao.getBankBalance("608502111");
		BigDecimal funds = accountDao.getAccountFunds("ABC123");
		
		assertTrue(balance.compareTo(oldBalance.add(amt)) == 0);
		assertTrue(funds.compareTo(oldFunds.subtract(amt)) == 0);
	}
}
