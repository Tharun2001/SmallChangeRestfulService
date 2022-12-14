package com.fidelity.smallChange.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fidelity.smallChange.business.Holding;

@Mapper
public interface HoldingMapper {
	List<Holding> getAllHoldings(String acctnum);

	Holding getHoldingBySecurityId(@Param("clientId") String clientId, @Param("s_id") int s_id);

	void addHolding(@Param("clientId") String clientId, @Param("holding") Holding holding);

	void updateHolding(@Param("clientId") String clientId, @Param("holding") Holding holding);

	void deleteHolding(@Param("clientId") String clientId, @Param("holding") Holding holding);

}
