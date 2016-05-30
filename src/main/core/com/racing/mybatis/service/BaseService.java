package com.racing.mybatis.service;

import com.racing.model.AccountTransDetail;


public interface BaseService<T> {
	int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    AccountTransDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
