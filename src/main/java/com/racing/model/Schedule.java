package com.racing.model;

import com.racing.mybatis.mapper.BaseEntity;

public class Schedule extends BaseEntity {
	private String jobId;

	private String jobName;

	private String jobGroup;

	// 0未启动 1已启动 2加入中 3已暂停 4已停止 9异常
	private String jobStatus;

	private String jobClass;

	private String jobCron;

	private String jobDescription;

	private String jobMethod;

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