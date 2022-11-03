package com.fidelity.smallChange.integration;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fidelity.smallChange.business.Trade;

public interface TradeDao {
	List<Trade> getAllTrades(String accNum);
	void transactSecurity(int t_id,String accNum, Trade trade, int s_id);
	List<Trade> getTradesFilterbyAmount(String accNum, double startAmt,double endAmt);
	List<Trade> getTradesFilterbySymbol(String accNum, String symbol);
}
