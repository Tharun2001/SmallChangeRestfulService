package com.fidelity.smallChange.integration.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fidelity.smallChange.business.User;
import com.fidelity.smallChange.business.Preference;

@Mapper
public interface UserDaoMapper {
	List<User> getAllUsers();
	User loginUser(@Param("username") String username, @Param("password") String password);
	int signUpUser(User p);
	int deleteUser(String username);
	int setUserPreferences(Preference up);
}
