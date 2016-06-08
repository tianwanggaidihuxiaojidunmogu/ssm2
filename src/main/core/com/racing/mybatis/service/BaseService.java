package com.racing.mybatis.service;

import com.racing.mybatis.mapper.BaseEntity;


public interface BaseService<T> {
	int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    BaseEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
