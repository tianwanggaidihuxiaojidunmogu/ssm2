package com.racing.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.racing.service.AccountTransDetailService;

@RestController
public class AccountTransDetailController {

	@Autowired
	AccountTransDetailService accountTransDetailService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Map<String, Object> test() {
		
		return null;
	}
}
