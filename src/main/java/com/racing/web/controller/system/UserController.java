package com.racing.web.controller.system;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.racing.commons.MD5Util;
import com.racing.model.system.User;
import com.racing.service.system.UserService;
import com.racing.web.controller.BaseController;

@RestController
@RequestMapping(value = "/system/user")
public class UserController extends BaseController {

	@Autowired
	UserService userService;

	/**
	 * 用户登录
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public Map<String, Object> login(@RequestParam("account") String account, @RequestParam("password") String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(RETURN_CODE, SUCCESS);
		User user = userService.getUserByAccount(account);

		if (user == null)
			result.put(RETURN_CODE, FAILED);
		if (MD5Util.encode2String(password).equals(user.getPassword()))
			result.put(RETURN_CODE, FAILED);

		if (FAILED.equals(MapUtils.getString(result, result, ""))) {
			result.put(RETURN_MSG, LOGIN_FAILED);
		} else {
			result.put(RETURN_MSG, LOGIN_SUCCESS);
		}

		return result;
	}
}
