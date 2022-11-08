package com.fidelity.smallChange.service;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.exceptions.InsufficientFundsException;

public interface TradeService {
	void transactSecurity(String clientId, Trade trade, int s_id) throws InsufficientFundsException;
}
