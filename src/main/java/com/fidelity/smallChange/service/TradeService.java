package com.fidelity.smallChange.service;

import com.fidelity.smallChange.business.Holding;

public interface TradeService {
	void buySecurity(String acctnum, Holding holding);
	void SellSecurity(String acctnum, Holding holding);
}
