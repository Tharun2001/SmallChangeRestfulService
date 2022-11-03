package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
		Holding holding = dao.getHoldingBySecurityId("ABC123",1);
		assertNotNull(holding);
	}
	
	@Test
	void addHolding() {
		Security security = new Security(2, "Tesla Inc","TSLA",733.8,"Main Index");
		Holding holding = new Holding(2,2,security,10, 2000);
		
		dao.addHolding("ABC123", holding);
		
		Holding holding2 = dao.getHoldingBySecurityId("ABC123",2);
		assertNotNull(holding2);
	}

}
