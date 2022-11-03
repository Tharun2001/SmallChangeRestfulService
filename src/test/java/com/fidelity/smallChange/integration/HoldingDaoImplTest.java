package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
		List<Holding> holdings = dao.getAllHoldings("ABC123");
		assertTrue(holdings.size() > 0);
		System.out.println(holdings.get(0));
	}

	@Test
	void getHoldingBySecurityId() {
		Holding holding = dao.getHoldingBySecurityId("ABC123", 1);
		assertNotNull(holding);
	}

	@Test
	void addHolding() {
		Security security = new Security(2, "Tesla Inc", "TSLA", 733.8, "Main Index");
		Holding holding = new Holding(2, 2, security, 10, 2000);

		dao.addHolding("ABC123", holding);

		Holding holding2 = dao.getHoldingBySecurityId("ABC123", 2);
		assertNotNull(holding2);
	}

	@Test
	void updateHolding() {
		Security security = new Security(2, "Tesla Inc", "TSLA", 733.8, "Main Index");
		Holding holding = dao.getHoldingBySecurityId("ABC123", 1);// new Holding(2,1,security,20, 2000);
		assertEquals(holding.getInvestedAmount(), 1000);

		holding.setInvestedAmount(2000);
		holding.setHoldingQuantity(20);

		dao.updateHolding("ABC123", holding);
//
//		Holding holding2 = dao.getHoldingBySecurityId("ABC123", 1);
//
//		assertEquals(holding2, holding);
	}
}
