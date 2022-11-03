package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.*;


@SpringBootTest
@Transactional
public class UserDaoImplTest {
	
	@Autowired
	private UserDao dao;
	
	@Test
	void testGetAllUsers() {
		List<User> users = dao.getAllUsers();
		assertTrue(users.size() > 0);
	}

}
