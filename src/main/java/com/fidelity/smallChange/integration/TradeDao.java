package com.fidelity.smallChange.integration;

import java.util.List;
import com.fidelity.smallChange.business.Trade;

public interface TradeDao {
	List<Trade> getAllTrades(String accNum);
	void buySecurity(int t_id,String accNum, Trade trade);
}
