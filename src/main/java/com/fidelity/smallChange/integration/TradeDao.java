package com.fidelity.smallChange.integration;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.business.TradeFilter;
import com.fidelity.smallChange.dto.FilterDto;

public interface TradeDao {
	List<Trade> getAllTrades(String clientId);
	void transactSecurity(String clientId, Trade trade, int s_id);
	List<Trade> getTradesWithFilter(String clientId, TradeFilter filter);
}
