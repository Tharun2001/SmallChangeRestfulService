package com.fidelity.smallChange.integration;

import java.util.List;

import com.fidelity.smallChange.business.Holding;


public interface HoldingDao {
	List<Holding> getAllHoldings(String acctnum);
	Holding getHoldingBySecurityId(String acctnum, int s_id);
	void addHolding(String acctnum, Holding holding);		
}
