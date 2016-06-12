package com.racing.persistence;

import java.util.List;

import com.racing.model.Schedule;
import com.racing.mybatis.mapper.BaseMapper;

public interface ScheduleMapper extends BaseMapper<Schedule> {
	int deleteByPrimaryKey(String jobId);

	int insert(Schedule record);

	int insertSelective(Schedule record);

	Schedule selectByPrimaryKey(String jobId);

	int updateByPrimaryKeySelective(Schedule record);

	int updateByPrimaryKey(Schedule record);

	List<Schedule> selectByJobStatus(String jobStatus);
}