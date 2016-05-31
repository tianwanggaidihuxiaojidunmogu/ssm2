package com.racing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.model.AccountTransDetail;
import com.racing.mybatis.service.impl.BaseServiceImpl;
import com.racing.persistence.AccountTransDetailMapper;
import com.racing.service.AccountTransDetailService;

@Service
public class AccountTransDetailServiceImpl extends BaseServiceImpl<AccountTransDetail> implements AccountTransDetailService {

	@Autowired
	AccountTransDetailMapper accountTransDetailMapper;

}
