package com.fidelity.smallChange.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.Security;
import com.fidelity.smallChange.integration.mapper.SecurityMapper;



@Repository
public class SecurityDaoImpl implements SecurityDao{
	
	@Autowired
	private SecurityMapper mapper;

	
	@Override
	public List<Security> getSecurities() {
		return mapper.getSecurities();
	}
	

	@Override
	public void insertSecurity(Security security) {
		mapper.insertSecurity(security);
		return;
	}
	  
	@Override
	public void deleteSecurity(int sId) {
		mapper.deleteSecurity(sId);
		return;
	}
	@Override
	public void updateSecurity(Security security) {			
		mapper.updateSecurity(security);
		return;
	}

}
