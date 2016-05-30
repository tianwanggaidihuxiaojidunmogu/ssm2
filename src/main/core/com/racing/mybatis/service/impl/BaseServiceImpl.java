package com.racing.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.racing.model.AccountTransDetail;
import com.racing.mybatis.mapper.BaseMapper;
import com.racing.mybatis.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	BaseMapper<T> baseMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		return baseMapper.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}

	@Override
	public AccountTransDetail selectByPrimaryKey(String id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}

}
