package com.fidelity.smallChange.integration;

import java.sql.Timestamp;
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
	public void transactSecurity(int t_id, String accNum, Trade trade, int s_id) {
		mapper.transactSecurity(t_id, accNum,trade,s_id, Timestamp.valueOf(trade.getTrade_time()));
	}

}
