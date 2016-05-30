package com.racing.mybatis.mapper;

import com.racing.model.AccountTransDetail;

public interface BaseMapper<T> {
	int deleteByPrimaryKey(String id);

	int insert(T record);

	int insertSelective(T record);

	AccountTransDetail selectByPrimaryKey(String id);

	int updateByPrimaryKey(T record);

	int updateByPrimaryKeySelective(T record);
}
