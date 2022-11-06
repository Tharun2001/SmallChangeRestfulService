package com.fidelity.smallChange.integration.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.fidelity.smallChange.business.Trade;
import com.fidelity.smallChange.business.TradeFilter;


@Mapper
public interface TradeMapper {
	List<Trade> getAllTrades(String clientId);
	void transactSecurity(
			@Param("clientId") String clientId,
			@Param("trade") Trade trade,
			@Param("s_id") int s_id,
			@Param("timestamp") Timestamp timestamp);
	List<Trade> getTradesWithFilter(@Param("clientId") String clientId,@Param("filter") TradeFilter filter);
}
