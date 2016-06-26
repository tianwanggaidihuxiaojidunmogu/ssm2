package com.racing.service.system.impl;

import org.springframework.stereotype.Service;

import com.racing.model.system.User;
import com.racing.mybatis.service.impl.BaseServiceImpl;
import com.racing.service.system.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

}
