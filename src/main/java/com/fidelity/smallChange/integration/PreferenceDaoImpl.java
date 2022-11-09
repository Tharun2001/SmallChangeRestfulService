package com.fidelity.smallChange.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.Preference;
import com.fidelity.smallChange.integration.mapper.PreferenceMapper;

@Repository
public class PreferenceDaoImpl implements PreferenceDao {
	
	@Autowired
	private PreferenceMapper mapper;
	
	@Override
	public Preference getPreference(String username) {
		return mapper.getPreference(username);
	}

	@Override
	public void insertPreference(Preference preference) {
		mapper.insertPreference(preference);
	}

	@Override
	public void updatePreference(Preference preference) {
		mapper.updatePreference(preference);
	}

}
