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
		List<Profile> users = dao.getAllUsers();
		assertTrue(users.size() > 0);
	}
	
	@Test
	void testSignUpNewUser() {
		int count = dao.signupUser(new Profile("Elend", "Venture", LocalDate.now(), "Elend", "elend", "elend@smallchange.com", "+91-1234567890", 5));
		assertEquals(count, 1);
	}
	
	@Test
	void testSignUpNewUserWithExistingUsername() {
		assertThrows(DuplicateKeyException.class, () -> {
			int count = dao.signupUser(new Profile("Elend", "Venture", LocalDate.now(), "Aryan", "elend", "elend@smallchange.com", "+91-1234567890", 5));
	    });
	}
	
	@Test
	void testSettingUserPreferences() {
		dao.setUserPreferences(new UserPreferences("Aryan", "Trading", 3, IncomeCategory.MIDDLE, 7));
	}
	
	@Test
	void testSettingUserPreferencesForInvalidUser() {
		assertThrows(DataIntegrityViolationException.class, () -> {
			dao.setUserPreferences(new UserPreferences("a", "Trading", 3, IncomeCategory.MIDDLE, 7));
	    });
	}
	
	@Test
	void testLoginUserWithCorrectCredentials() {
		int count = dao.loginUser(new User("Aryan", "aryan"));
		assertEquals(count, 1);
	}
	
	@Test
	void testLoginUserWithIncorrectCredentials() {
		int count = dao.loginUser(new User("Aryan", "aryan1"));
		assertEquals(count, 0);
	}
	
	@Test
	void testDeletingNonExistentUser() {
		int count = dao.deleteUser("ARY");
		assertEquals(count, 0);
	}
	
	@Test
	void testDeletingValidUser() {
		dao.signupUser(new Profile("Elend", "Venture", LocalDate.now(), "Elend", "elend", "elend@smallchange.com", "+91-1234567890", 5));
		int count = dao.deleteUser("Elend");
		assertEquals(count, 1);
	}
}
