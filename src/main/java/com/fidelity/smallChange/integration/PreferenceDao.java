package com.fidelity.smallChange.integration;

import com.fidelity.smallChange.business.Preference;

public interface PreferenceDao {
	Preference getPreference(String username);
	void insertPreference(Preference preference);
	void updatePreference(Preference preference);
}
