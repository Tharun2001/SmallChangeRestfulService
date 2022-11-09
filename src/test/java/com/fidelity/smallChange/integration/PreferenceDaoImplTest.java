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
	void getPreference() {
		Preference preference = dao.getPreference("Aryan");
		assertNotNull(preference);
	}
	
	@Test
	void insertPreference() {
		User user1 = new User("Ethan", "Venture", LocalDate.now(), "elend@smallchange.com", "+91-1234567890", "Ethan", "elend");
		userDao.signupUser(user1);
		Preference preference = new Preference("Ethan", "Trading", 4, "Middle", "5 years");
		dao.insertPreference(preference);
		assertEquals(dao.getPreference("Ethan"), preference);
	}
	
	@Test
	void updatePreference() {
		Preference preference= dao.getPreference("Aryan");
		
		assertEquals(preference.getRisk(),3);
		
		preference.setRisk(4);
		
		dao.updatePreference(preference);
		assertEquals(preference.getRisk(),4);
	}

}
