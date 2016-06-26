package com.racing.service.system;

import com.racing.model.system.User;
import com.racing.mybatis.service.BaseService;

public interface UserService extends BaseService<User> {

	public User getUserByAccount(String account);
}
