package com.racing.model.schedule;

import com.racing.mybatis.mapper.BaseEntity;
import com.racing.sql.DBField;
import com.racing.sql.DBIndex;
import com.racing.sql.DBTable;

@DBTable(remark = "定时计划任务")
public class Schedule extends BaseEntity {

	@DBIndex
	@DBField(length = 100, remark = "任务ID")
	private String jobId;
	@DBField(length = 100, remark = "任务名称")
	private String jobName;
	@DBField(length = 100, remark = "任务分组")
	private String jobGroup;
	@DBField(length = 1, remark = "任务状态 0未启动 1已启动 2加入中 3已暂停 4已停止 9异常")
	private String jobStatus;
	@DBField(length = 100, remark = "任务调用类全路径")
	private String jobClass;
	@DBField(length = 100, remark = "CRON表达式")
	private String jobCron;
	@DBField(length = 255, remark = "描述")
	private String jobDescription;
	@DBField(length = 100, remark = "调用方法名称")
	private String jobMethod;
	@DBField(length = 1, remark = "是否更新")
	private String isUpdate;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId == null ? null : jobId.trim();
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName == null ? null : jobName.trim();
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup == null ? null : jobGroup.trim();
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass == null ? null : jobClass.trim();
	}

	public String getJobCron() {
		return jobCron;
	}

	public void setJobCron(String jobCron) {
		this.jobCron = jobCron == null ? null : jobCron.trim();
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription == null ? null : jobDescription.trim();
	}

	public String getJobMethod() {
		return jobMethod;
	}

	public void setJobMethod(String jobMethod) {
		this.jobMethod = jobMethod == null ? null : jobMethod.trim();
	}

	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	@Override
	public boolean equals(Object obj) {
		Schedule newSchedule = (Schedule) obj;
		if (newSchedule.getJobId().equals(this.getJobId()))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return this.getJobId().hashCode();
	}

}