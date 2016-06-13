package com.racing.web.controller.schedule;

import java.util.HashMap;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.racing.model.schedule.Schedule;
import com.racing.schedule.manager.JobManager;
import com.racing.service.schedule.ScheduleService;
import com.racing.web.controller.BaseController;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController extends BaseController {

	@Autowired
	ScheduleService scheduleService;

	@Autowired
	JobManager jobManager;

	@RequestMapping(value = "/{operate}/{scheduleJobId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> pauseSchedule(@PathVariable String operate, @PathVariable String scheduleJobId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Schedule schedule = scheduleService.selectByPrimaryKey(scheduleJobId);
			if (schedule == null) {
				result.put(RETURN_CODE, ERROR);
				result.put(RETURN_MSG, "未找到定时任务对象!");
				return result;
			}
			if ("pause".equals(operate)) {
				jobManager.pauseJob(schedule);
			} else if ("resume".equals(operate)) {
				jobManager.resumeJob(schedule);
			} else if ("stop".equals(operate)) {
				jobManager.deleteJob(schedule);
			} else if ("run".equals(operate)) {
				jobManager.runAJobNow(schedule);
			} else {
				result.put(RETURN_CODE, ERROR);
				result.put(RETURN_MSG, IDENTIFIER_INVALID);
				return result;
			}

			result.put(RETURN_CODE, SUCCESS);
			result.put(RETURN_MSG, SUCCESS_MSG);
		} catch (SchedulerException e) {
			e.printStackTrace();
			result.put(RETURN_CODE, ERROR);
			result.put(RETURN_MSG, e.getMessage());

		}
		return result;
	}
	
	@RequestMapping(value="/init")
	public @ResponseBody Map<String,Object> init(){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			jobManager.init();
		} catch (SchedulerException e) {
			e.printStackTrace();
			result.put(RETURN_CODE, ERROR);
			result.put(RETURN_MSG, "初始化失败!");
			return result;
		}
		result.put(RETURN_CODE, SUCCESS);
		result.put(RETURN_MSG, SUCCESS_MSG);
		return result;
	}

}
