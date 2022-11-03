package com.fidelity.smallChange.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.fidelity.smallChange.business.Trade;


@Mapper
public interface TradeMapper {
	List<Trade> getAllTrades(String accNum);
	void buySecurity(@Param("t_id") int t_id, 
			@Param("acctnum") String accNum,
			@Param("trade") Trade trade);
}
