package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.Account;

@SpringBootTest
@Transactional
class AccountDaoImplTest {
	@Autowired
	private AccountDao dao;
	
	@Test
	void testGetAccount() {
		Account acc = dao.getAccount("Aryan");
		assertNotNull(acc);
	}
	
	@Test
	void testAddAccount() {
		Account account = new Account("Tharun", "XYZ001", BigDecimal.valueOf(100000));
		
		dao.createAccount(account);
		
		Account acc = dao.getAccount("Tharun");
		assertNotNull(acc);
	}
	
	@Test
	void testCheckIfClientExists() {
		int value2 = dao.checkIfAccountExists("ABC001");
		
		assertTrue(value2 == 0);
	}
	
	@Test
	void testGetFunds() {
		BigDecimal funds = dao.getAccountFunds("ABC123");
		assertTrue(funds.compareTo(BigDecimal.ZERO) != 0);
	}
	
	@Test
	void testupdateFunds() {
		BigDecimal newfunds = BigDecimal.valueOf(900000);
		int value = dao.updateFunds("ABC123", newfunds);
		BigDecimal funds = 	dao.getAccountFunds("ABC123");
		
		assertTrue(value==1);
		assertTrue(funds.compareTo(BigDecimal.ZERO) != 0);
	}
}
