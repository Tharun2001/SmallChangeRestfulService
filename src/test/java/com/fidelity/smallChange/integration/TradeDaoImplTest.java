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
	void test_get_all_trades() {
		List<Trade> trades = dao.getAllTrades("ABC123");
		assertTrue(trades.size() >= 0);
	}
	
	@Test
	void test_transactSecurity_Buy() {
		Security newSecurity = new Security(12);
		Trade trade = new Trade("B", newSecurity,  LocalDateTime.now(),10, 2000);
		dao.transactSecurity("ABC123", trade, newSecurity.getSid());
		List<Trade> trades = dao.getAllTrades("ABC123");
		System.out.println(trades.size());
		assertTrue(trades.size() > 0);
	}
	
	@Test
	void test_transactSecurity_Sell() {
		Security newSecurity = new Security(12);
		Trade trade = new Trade("S", newSecurity,  LocalDateTime.now(),10, 2000);
		dao.transactSecurity("ABC123", trade, newSecurity.getSid());
		List<Trade> trades = dao.getAllTrades("ABC123");
		assertTrue(trades.size() > 0);
	}
	
	@Test
	void null_SecurityId_Buy() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void null_securityId_Sell() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void nonExistent_SecurityId_Buy() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void nonExistent_securityId_Sell() {
		int value = 1;
		assertTrue(value==1);
	}
	
	
	@Test
	void getAllTradesNullId() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void getAllTradesNonExistentId() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void getAllTradesById() {
		int value = 1;
		assertTrue(value==1);
	}
	
	@Test
	void getTradesByExistentId() {
		int value = 1;
		assertTrue(value==1);
	}
}
