package com.fidelity.smallChange.integration;

import java.util.List;

import com.fidelity.smallChange.business.Security;


public interface SecurityDao {
	List<Security> getSecurities();
	void insertSecurity(Security security);
	void deleteSecurity(int sId);
	void updateSecurity(Security security);
}
