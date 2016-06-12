package com.racing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racing.model.Schedule;
import com.racing.mybatis.service.impl.BaseServiceImpl;
import com.racing.persistence.ScheduleMapper;
import com.racing.service.ScheduleService;

@Service
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule> implements ScheduleService {

	@Autowired
	ScheduleMapper scheduleMapper;

	@Override
	public List<Schedule> selectByJobStatus(String jobStatus) {
		return scheduleMapper.selectByJobStatus(jobStatus);
	}

	@Override
	public int run(Schedule schedule) {
		schedule.setJobStatus("1");
		return scheduleMapper.updateByPrimaryKey(schedule);
	}

	@Override
	public int executing(Schedule schedule) {
		schedule.setJobStatus("2");
		return scheduleMapper.updateByPrimaryKey(schedule);
	}

	@Override
	public int pause(Schedule schedule) {
		schedule.setJobStatus("3");
		return scheduleMapper.updateByPrimaryKey(schedule);
	}

	@Override
	public int stop(Schedule schedule) {
		schedule.setJobStatus("4");
		return scheduleMapper.updateByPrimaryKey(schedule);
	}

	@Override
	public int exception(Schedule schedule) {
		schedule.setJobStatus("9");
		return scheduleMapper.updateByPrimaryKey(schedule);
	}

}
