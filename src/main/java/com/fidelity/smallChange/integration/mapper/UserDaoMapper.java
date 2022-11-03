package com.fidelity.smallChange.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.business.UserPreferences;

@Mapper
public interface UserDaoMapper {
	List<Profile> getAllUsers();
	int signUpUser(Profile p);
	int deleteUser(String username);
	int loginUser(User user);
	int setUserPreferences(UserPreferences up);
}
