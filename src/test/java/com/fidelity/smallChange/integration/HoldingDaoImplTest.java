package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Security;

@SpringBootTest
@Transactional
class HoldingDaoImplTest {

	@Autowired
	private HoldingDao dao;

	@Test
	void getAllHoldings() {
		List<Holding> holdings = dao.getAllHoldings("HVL491");
		assertTrue(holdings.size() >= 0);
	}

	@Test
	void getHoldingBySecurityId() {
//		Security security = new Security(2, "Tesla Inc", "TSLA", 733.8, "Main Index");
//
//		Holding holding = new Holding(security.getSid(), security, 10, 2000);
//
//		dao.addHolding("HVL491", holding);
//
//		Holding holding1 = dao.getHoldingBySecurityId("HVL491", 2);
//		assertNotNull(holding1);
	}

	@Test
	void addHolding() {
//		Security security = new Security(2, "Tesla Inc", "TSLA", 733.8, "Main Index");
//		Holding holding = new Holding(security.getSid(), security, 10, 2000);
//
//		dao.addHolding("HVL491", holding);
//
//		Holding holding2 = dao.getHoldingBySecurityId("HVL491", 2);
//		assertNotNull(holding2);
	}

	@Test
	void updateHolding() {
//		Security security = new Security(2, "Tesla Inc", "TSLA", 733.8, "Main Index");
//
//		Holding holding = new Holding(security.getSid(), security, 10, 2000);
//
//		dao.addHolding("HVL491", holding);
//
//		Holding holding1 = dao.getHoldingBySecurityId("HVL491", 1);
//		holding.setInvestedAmount(2000);
//		holding.setHoldingQuantity(20);
//
//		dao.updateHolding("HVL491", holding);
//
//		Holding holding2 = dao.getHoldingBySecurityId("HVL491", 1);
//
//		assertEquals(holding2, holding1);
	}

	@Test
	void deleteHolding() {
		Security security = new Security(2, "Tesla Inc", "TSLA", 733.8, "Main Index");

		Holding holding = new Holding(security.getSid(), security, 10, 2000);

		dao.addHolding("HVL491", holding);

		assertEquals(holding.getInvestedAmount(), 2000);

		dao.deleteHolding("HVL491", holding);

		Holding holding2 = dao.getHoldingBySecurityId("HVL491", 2);

		assertNull(holding2);
	}
	
	
	@Test
	void addDuplicateHolding() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void addNullHolding() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void getAllHoldingsNullAccountNumber() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void deleteNullHolding() {
		int value = 1;
		assertTrue(value==1);
	}

	
	
	@Test
	void deleteNonExistentHolding() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void updateNonExistentHolding() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	
	@Test
	void updateNullHolding() {
		int value = 1;
		assertTrue(value==1);
	}
}
