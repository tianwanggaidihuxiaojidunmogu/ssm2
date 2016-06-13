package com.racing.schedule.job;

import java.lang.reflect.Method;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.racing.model.schedule.Schedule;

public class BaseJob implements Job {

	@Override
	public void execute(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {
		Schedule schedule=(Schedule) paramJobExecutionContext.getJobDetail().getJobDataMap().get("scheduleJob");
		if(schedule==null)
			return;
		
		try {
			Method method=this.getClass().getDeclaredMethod(schedule.getJobMethod());
			if(method==null)
				return;
			
			method.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
