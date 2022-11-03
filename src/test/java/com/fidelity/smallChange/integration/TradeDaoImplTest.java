package com.fidelity.smallChange.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.business.Trade;

@SpringBootTest
@Transactional
class TradeDaoImplTest {
	@Autowired
	TradeDao dao;
	
	@Test
	void test() {
		List<Trade> trades = dao.getAllTrades("ABC123");
		assertTrue(trades.size() > 0);
	}
	
	@Test
	void test_transactSecurity_buy() {
		 Security newSecurity = new Security(12, "Spacex", "TSLA",733.8,"Main Index");
		 Trade trade = new Trade("B", newSecurity,  LocalDateTime.now(),10, 2000);
		 dao.transactSecurity(5, "ABCE123", trade, newSecurity.getStockId());
		List<Trade> trades = dao.getAllTrades("ABC123");
		assertTrue(trades.size() > 1);
	}
	
	@Test
	void test_transactSecurity_Sell() {
		 Security newSecurity = new Security(12, "Spacex", "TSLA",733.8,"Main Index");
		 Trade trade = new Trade("S", newSecurity,  LocalDateTime.now(),10, 2000);
		 dao.transactSecurity(5, "ABCE123", trade, newSecurity.getStockId());
		List<Trade> trades = dao.getAllTrades("ABC123");
		assertTrue(trades.size() > 1);
	}
	
}
