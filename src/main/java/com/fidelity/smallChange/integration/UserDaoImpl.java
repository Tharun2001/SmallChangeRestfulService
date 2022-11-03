package com.fidelity.smallChange.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.Profile;
import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.business.UserPreferences;
import com.fidelity.smallChange.integration.mapper.UserDaoMapper;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserDaoMapper userMapper;

	@Override
	public List<Profile> getAllUsers() {
		//logger.debug("enter getAllUsers");
		return userMapper.getAllUsers();
	}

	@Override
	public int signupUser(Profile p) {
		//logger.debug("enter signupUser");
		return userMapper.signUpUser(p);
	}

	@Override
	public int deleteUser(String username) {
		//logger.debug("enter deleteUser");
		return userMapper.deleteUser(username);
	}

	@Override
	public int loginUser(User user) {
		//logger.debug("enter loginUser");
		return userMapper.loginUser(user);
	}

	@Override
	public int setUserPreferences(UserPreferences up) {
		return userMapper.setUserPreferences(up);
	}


}
