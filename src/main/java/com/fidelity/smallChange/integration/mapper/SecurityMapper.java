package com.fidelity.smallChange.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fidelity.smallChange.business.Security;


@Mapper
public interface SecurityMapper {
	List<Security> getSecurities();
	void insertSecurity(Security security);
	void deleteSecurity(int sId);
	void updateSecurity(Security security);
}
