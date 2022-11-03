package com.fidelity.smallChange.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.integration.mapper.UserDaoMapper;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserDaoMapper userMapper;

	@Override
	public List<User> getAllUsers() {
		//logger.debug("enter getAllUsers");
		return userMapper.getAllUsers();
	}

	@Override
	public int signupUser(User p) {
		//logger.debug("enter signupUser");
		return userMapper.signUpUser(p);
	}

	@Override
	public User loginUser(String username, String password) {
		//logger.debug("enter loginUser");
		return userMapper.loginUser(username, password);
	}

}
