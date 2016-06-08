package com.racing.mybatis.mapper;

public abstract interface BaseMapper<T> {
	int deleteByPrimaryKey(String id);

	int insert(T record);

	int insertSelective(T record);

	BaseEntity selectByPrimaryKey(String id);

	int updateByPrimaryKey(T record);

	int updateByPrimaryKeySelective(T record);
}
