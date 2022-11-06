package com.fidelity.smallChange.integration;

import java.util.List;

import com.fidelity.smallChange.business.Holding;

public interface HoldingDao {
	List<Holding> getAllHoldings(String clientId);

	Holding getHoldingBySecurityId(String clientId, int s_id);

	void addHolding(String clientId, Holding holding);

	void updateHolding(String clientId, Holding holding);

	void deleteHolding(String clientId, Holding holding);
}
