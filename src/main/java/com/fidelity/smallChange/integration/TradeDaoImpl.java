package com.fidelity.smallChange.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.integration.mapper.TradeMapper;



@Repository
public class TradeDaoImpl implements TradeDao{
	
	@Autowired
	TradeMapper mapper;
	
	@Override
	public List<Trade> getAllTrades(String accNum) {
		return mapper.getAllTrades(accNum);
	}

	@Override
	public void buySecurity(int t_id, String accNum, Trade trade) {
		mapper.buySecurity(t_id, accNum,trade );
	}

}
