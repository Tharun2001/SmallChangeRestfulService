package com.fidelity.smallChange.integration;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.business.TradeFilter;
import com.fidelity.smallChange.integration.mapper.TradeMapper;



@Repository
public class TradeDaoImpl implements TradeDao{
	
	@Autowired
	TradeMapper mapper;
	
	@Override
	public List<Trade> getAllTrades(String clientId) {
		return mapper.getAllTrades(clientId);
	}

	@Override
	public void transactSecurity(String clientId, Trade trade, int s_id) {
		mapper.transactSecurity(clientId,trade,s_id, Timestamp.valueOf(trade.getTrade_time()));
	}

	@Override
	public List<Trade> getTradesWithFilter(String clientId, TradeFilter filter) {
		// TODO Auto-generated method stub
		return mapper.getTradesWithFilter(clientId, filter);
	}

}
