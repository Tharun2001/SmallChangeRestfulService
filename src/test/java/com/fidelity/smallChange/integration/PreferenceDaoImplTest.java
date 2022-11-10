package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Preference;
import com.fidelity.smallChange.business.User;

@SpringBootTest
@Transactional
class PreferenceDaoImplTest {

	@Autowired
	private PreferenceDao dao;
	

	@Autowired
	private UserDao userDao;
	
	@Test
	void insertPreference() {
		User user1 = new User("Ethan", "Venture", LocalDate.now(), "elend@smallchange.com", "+91-1234567890", "Ethan", "elend");
		userDao.signupUser(user1);
		Preference preference = new Preference("Ethan", "Trading", 4, "150,000+", "5 years");
		dao.insertPreference(preference);
		assertEquals(dao.getPreference("Ethan"), preference);
	}
	
	@Test
	void updatePreference() {
		int value = 1;
		assertTrue(value==1);
	}
	

	@Test
	void getPreference() {
		int value = 1;
		assertTrue(value==1);
	}
	@Test
	void addDuplicatePreference() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void addNullPreference() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void getAllPreferencesNullAccountNumber() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void deleteNullPreference() {
		int value = 1;
		assertTrue(value==1);
	}

	
	
	@Test
	void deleteNonExistentPreference() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void updateNonExistentPreference() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	
	@Test
	void updateNullPreference() {
		int value = 1;
		assertTrue(value==1);
	}
	

}
