package com.fidelity.smallChange.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.integration.mapper.HoldingMapper;

@Repository
public class HoldingDaoImpl implements HoldingDao {

	@Autowired
	private HoldingMapper mapper;

	@Override
	public List<Holding> getAllHoldings(String clientId) {
		return mapper.getAllHoldings(clientId);
	}

	@Override
	public Holding getHoldingBySecurityId(String clientId, int s_id) {
		return mapper.getHoldingBySecurityId(clientId, s_id);
	}

	@Override
	public void addHolding(String clientId, Holding holding) {
		mapper.addHolding(clientId, holding);
	}

	@Override
	public void updateHolding(String clientId, Holding holding) {
		mapper.updateHolding(clientId, holding);
	}

	@Override
	public void deleteHolding(String clientId, Holding holding) {
		mapper.deleteHolding(clientId, holding);
	}

}
