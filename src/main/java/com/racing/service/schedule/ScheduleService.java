package com.racing.service.schedule;

import java.util.List;

import com.racing.model.schedule.Schedule;
import com.racing.mybatis.service.BaseService;

public interface ScheduleService extends BaseService<Schedule> {

	public List<Schedule> selectByJobStatus(String jobStatus);

	public int run(Schedule schedule);

	public int executing(Schedule schedule);

	public int pause(Schedule schedule);

	public int stop(Schedule schedule);

	public int exception(Schedule schedule);
}
