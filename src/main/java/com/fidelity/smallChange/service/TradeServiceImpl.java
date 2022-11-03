package com.fidelity.smallChange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidelity.smallChange.business.Holding;
import com.fidelity.smallChange.integration.HoldingDao;
import com.fidelity.smallChange.integration.TradeDao;

@Service
public class TradeServiceImpl implements TradeService{
	@Autowired 
	HoldingDao holdingDao;
	
	@Autowired
	TradeDao tradeDao;

	@Override
	public void buySecurity(String acctnum, Holding holding) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SellSecurity(String acctnum, Holding holding) {
		// TODO Auto-generated method stub
		
	}
	

}
