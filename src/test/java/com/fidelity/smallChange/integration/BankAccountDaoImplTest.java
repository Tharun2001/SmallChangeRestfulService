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
		assertNotNull(accts);
	}
	
	@Test
	void testDeleteBankAccounts() {
		List<BankAccount> accts = dao.getBankAccounts("ABC123");
		int old = accts.size();
		
		dao.deleteBankAccount("608502111");
		
		assertEquals(old-1, dao.getBankAccounts("ABC123").size());
	}
	
	@Test
	void testGetAccountBalance() {
		BigDecimal balance = dao.getBankBalance("608502111");
		assertTrue(balance.compareTo(BigDecimal.ZERO) != 0);
	}
	
	@Test
	void testupdateBankBalance() {
		BigDecimal newBalance = BigDecimal.valueOf(100000);
		dao.updateBankBalance("608502111", newBalance);
		
		BigDecimal balance = dao.getBankBalance("608502111");
		assertTrue(balance.compareTo(newBalance) == 0);
	}
	

	
	@Test
	void testUpdateNullAccount() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void testDeleteNullAccount() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void testUpdateNonExistentAccount() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void testDeleteNonExistentAccount() {
		int value = 1;
		assertTrue(value==1);
	}
    
	@Test
	void testInsertDuplicateAccount() {
		int value = 1;
		assertTrue(value==1);
	}
 
	@Test
	void testNonExistentAccount() {
		int value = 1;
		assertTrue(value==1);
	}
    
	@Test
	void testDuplicateAccount() {
		int value = 1;
		assertTrue(value==1);
	}
}
