package com.fidelity.smallChange.service;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Trade;

public interface TradeService {
	void transactSecurity(String accNum, Trade trade, int s_id);
}
