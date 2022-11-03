package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.BankAccount;

@SpringBootTest
@Transactional
class BankAccountDaoImplTest {
	@Autowired
	private BankAccountDao dao;
	
	@Test
	void testGetBankAccounts() {
		List<BankAccount> accts = dao.getBankAccounts("ABC123");
		assertTrue(accts.size() > 0);
	}
	
	@Test
	void testinsertBankAccounts() {
		BankAccount acct = new BankAccount("ABC123", "798502111", "XYZ bank", BigDecimal.valueOf(1150000));
		dao.insertBankAccount(acct);
		List<BankAccount> accts = dao.getBankAccounts("ABC123");
		assertTrue(accts.contains(acct));
	}
	
	@Test
	void testupdateBankAccounts() {
		BankAccount acct = new BankAccount("ABC123", "608502111", "ABC bank", BigDecimal.valueOf(2550000));
		dao.updateBankAccount(acct);
		
		List<BankAccount> accts = dao.getBankAccounts("ABC123");
		assertTrue(accts.contains(acct));
	}
	
	@Test
	void testDeleteBankAccounts() {
		List<BankAccount> accts = dao.getBankAccounts("ABC123");
		int old = accts.size();
		
		dao.deleteBankAccount("608502111");
		
		assertEquals(old-1, dao.getBankAccounts("ABC123").size());
	}
}
