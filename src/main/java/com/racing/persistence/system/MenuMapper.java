package com.racing.persistence.system;

import java.util.List;

import com.racing.model.system.Menu;
import com.racing.mybatis.mapper.BaseMapper;

public interface MenuMapper extends BaseMapper<Menu> {
	int deleteByPrimaryKey(Long id);

	int insert(Menu record);

	int insertSelective(Menu record);

	Menu selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);

}