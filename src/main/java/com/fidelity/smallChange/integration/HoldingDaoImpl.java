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
	public List<Holding> getAllHoldings(String acctnum) {
		return mapper.getAllHoldings(acctnum);
	}

	@Override
	public Holding getHoldingBySecurityId(String acctnum, int s_id) {
		return mapper.getHoldingBySecurityId(acctnum, s_id);
	}

	@Override
	public void addHolding(String acctnum, Holding holding) {
		mapper.addHolding(acctnum, holding);
	}

	@Override
	public void updateHolding(String acctnum, Holding holding) {
		mapper.updateHolding(acctnum, holding);
	}

	@Override
	public void deleteHolding(String acctnum, Holding holding) {
		mapper.deleteHolding(acctnum, holding);
	}

}
