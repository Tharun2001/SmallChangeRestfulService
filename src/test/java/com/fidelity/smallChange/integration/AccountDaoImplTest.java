package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.*;

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
	void test() {
		Account acc = dao.getAccount("Aryan");
		assertNotNull(acc);
	}
	
}
