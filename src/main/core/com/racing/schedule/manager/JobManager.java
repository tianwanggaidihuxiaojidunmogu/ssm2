package com.racing.schedule.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.racing.model.Schedule;
import com.racing.service.ScheduleService;

@Component
public class JobManager {

	private final Logger logger = Logger.getLogger(JobManager.class);

	@Autowired
	SchedulerFactoryBean schedulerFactoryBean;

	@Autowired
	ScheduleService scheduleService;

	public void init() throws SchedulerException {
		logger.info("Scheduler init...");
		List<Schedule> schedules = scheduleService.selectByJobStatus("1");

		logger.info(String.format("query waiting for running schedules size : %d", schedules.size()));

		for (Schedule schedule : schedules) {
			try {
				if (getRunningJob().contains(schedule))
					continue;
				addJob(schedule);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				scheduleService.exception(schedule);
			}
		}

	}

	public void shutdown() throws SchedulerException {
		logger.info("Scheduler shutdown...");
		this.schedulerFactoryBean.getScheduler().shutdown();
	}

	/**
	 * 获取所有计划中的任务列表
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public List<Schedule> getAllJob() throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
		List<Schedule> jobList = new ArrayList<Schedule>();
		for (JobKey jobKey : jobKeys) {
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			for (Trigger trigger : triggers) {
				logger.info(jobKey.getName());
				Schedule job = new Schedule();
				job.setJobName(jobKey.getName());
				job.setJobGroup(jobKey.getGroup());
				job.setJobDescription("触发器:" + trigger.getKey());
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				job.setJobStatus(triggerState.name());
				if (trigger instanceof CronTrigger) {
					CronTrigger cronTrigger = (CronTrigger) trigger;
					String cronExpression = cronTrigger.getCronExpression();
					job.setJobCron(cronExpression);
				}
				jobList.add(job);
			}
		}
		return jobList;
	}

	/**
	 * 所有正在运行的job
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public List<Schedule> getRunningJob() throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
		List<Schedule> jobList = new ArrayList<Schedule>(executingJobs.size());
		for (JobExecutionContext executingJob : executingJobs) {
			Schedule job = new Schedule();
			JobDetail jobDetail = executingJob.getJobDetail();
			JobKey jobKey = jobDetail.getKey();
			Trigger trigger = executingJob.getTrigger();
			job.setJobName(jobKey.getName());
			job.setJobGroup(jobKey.getGroup());
			job.setJobDescription("触发器:" + trigger.getKey());
			Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
			job.setJobStatus(triggerState.name());
			if (trigger instanceof CronTrigger) {
				CronTrigger cronTrigger = (CronTrigger) trigger;
				String cronExpression = cronTrigger.getCronExpression();
				job.setJobCron(cronExpression);
			}
			jobList.add(job);
		}
		return jobList;
	}

	/**
	 * 暂停一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void pauseJob(Schedule scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.pauseJob(jobKey);
		scheduleService.pause(scheduleJob);
	}

	/**
	 * 恢复一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void resumeJob(Schedule scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.resumeJob(jobKey);
		scheduleService.run(scheduleJob);
	}

	/**
	 * 删除一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void deleteJob(Schedule scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.deleteJob(jobKey);
		scheduleService.stop(scheduleJob);
	}

	/**
	 * 立即执行job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void runAJobNow(Schedule scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.triggerJob(jobKey);
	}

	/**
	 * 更新job时间表达式
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void updateJobCron(Schedule scheduleJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();

		TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());

		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getJobCron());

		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

		scheduler.rescheduleJob(triggerKey, trigger);
	}

	public void addJobs(BlockingQueue<Schedule> scheduleQueues) {
		Schedule schedule = null;
		while ((schedule = scheduleQueues.peek()) != null) {
			try {
				addJob(schedule);
				scheduleService.run(schedule);
			} catch (Exception e) {
				e.printStackTrace();
				scheduleService.exception(schedule);
			}
			scheduleQueues.remove(schedule);
		}
	}

	/**
	 * 添加任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void addJob(Schedule schedule) throws SchedulerException, ClassNotFoundException {
		if (schedule == null)
			return;
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		logger.info(String.format("add schedule > %s,%s", schedule.getJobName(), schedule.getJobGroup()));
		TriggerKey triggerKey = TriggerKey.triggerKey(schedule.getJobName(), schedule.getJobGroup());

		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

		// 不存在，创建一个
		if (null == trigger) {
			JobBuilder builder = JobBuilder.newJob().withIdentity(schedule.getJobName(), schedule.getJobGroup());
			builder.ofType((Class<? extends Job>) Class.forName(schedule.getJobClass()));
			builder.withDescription(schedule.getJobDescription());
			JobDetail jobDetail = builder.build();

			jobDetail.getJobDataMap().put("scheduleJob", schedule);

			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedule.getJobCron());

			trigger = TriggerBuilder.newTrigger().withIdentity(schedule.getJobName(), schedule.getJobGroup()).withSchedule(scheduleBuilder).build();

			scheduler.scheduleJob(jobDetail, trigger);
		} else {
			// Trigger已存在，那么更新相应的定时设置
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedule.getJobCron());

			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		}
	}

}
