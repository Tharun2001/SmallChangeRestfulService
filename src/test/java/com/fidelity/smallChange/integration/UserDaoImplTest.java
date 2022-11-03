package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.intThat;

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

	@Test
	void testloginUser() {
		int val = dao.loginUser("Tharun", "tharun");
		assertTrue(val ==1 );
	}
	
	@Test
	void testSignUpUser() {
		User user1 = new User("Elend", "Venture", LocalDate.now(), "elend@smallchange.com", "+91-1234567890", "Elend", "elend");
		dao.signupUser(user1);
		int val = dao.loginUser("Elend", "elend");
		assertTrue(val ==1 ); 
		assertTrue(val ==1 );
	}
}
