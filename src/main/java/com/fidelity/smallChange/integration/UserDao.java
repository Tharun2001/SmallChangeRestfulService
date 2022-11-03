package com.fidelity.smallChange.integration;

import java.util.List;

import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.business.UserPreferences;


public interface UserDao {
	List<Profile> getAllUsers();
	int signupUser(Profile p);
	int deleteUser(String username);
	int loginUser(User user);
	int setUserPreferences(UserPreferences up);
}
