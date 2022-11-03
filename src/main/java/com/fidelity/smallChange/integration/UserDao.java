package com.fidelity.smallChange.integration;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fidelity.smallChange.business.Preference;
import com.fidelity.smallChange.business.User;



public interface UserDao {
	List<User> getAllUsers();
	int signupUser(User p);
	User loginUser(@Param("username") String username, @Param("password") String password);
}
