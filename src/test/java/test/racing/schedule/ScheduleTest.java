package test.racing.schedule;

import java.util.UUID;

import org.apache.ibatis.type.JdbcType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.racing.service.ScheduleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:context/spring-config.xml","classpath:context/spring-mybatis.xml"})
public class ScheduleTest {

	@Autowired
	ScheduleService scheduleService;
	
	@Test
	public void addSchedule(){
//		Schedule schedule=new Schedule();
//		schedule.setJobId(UUID.randomUUID().toString());
//		schedule.setJobName("测试任务");
//		schedule.setJobGroup("测试");
//		schedule.setJobClass("com.racing.schedule.TestJob.class");
//		schedule.setJobMethod("test");
//		schedule.setJobCron("0/1 * * * * * ?");
//		schedule.setJobStatus(0);
//		schedule.setJobDescription("测试");
//		scheduleService.insert(schedule);
		
//		scheduleService.deleteByPrimaryKey("5387491f-1198-4749-a3e6-ee10a82166ae");
	}
}
