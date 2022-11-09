package com.fidelity.smallChange.integration.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.fidelity.smallChange.business.Preference;

@Mapper
public interface PreferenceMapper {
	Preference getPreference(String username);
	void insertPreference(Preference preference);
	void updatePreference(Preference preference);
	
}
