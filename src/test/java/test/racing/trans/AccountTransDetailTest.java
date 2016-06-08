package test.racing.trans;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.racing.model.Schedule;
import com.racing.service.ScheduleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:context/spring-config.xml","classpath:context/spring-mybatis.xml"})
public class AccountTransDetailTest {

	@Resource
	ScheduleService scheduleService;
	
	@Test
	public void insert(){
		Schedule schedule=new Schedule();
		schedule.setJobId("asdaf");
		schedule.setJobClass("asdasd");
		schedule.setJobCron("aaa");
		schedule.setJobGroup("");
		scheduleService.insert(schedule);
//		AccountTransDetail accountTransDetail=new AccountTransDetail();
//		Method[] methods=AccountTransDetail.class.getDeclaredMethods();
//		for(Method method:methods){
//			if(method.getName().indexOf("set")==0 && method.getParameterTypes().length==1 && method.getParameterTypes()[0].getName().equals(String.class.getName())){
//				try {
//					method.invoke(accountTransDetail, "a");
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		accountTransDetail.setCreateTime(new Date());
//		accountTransDetail.setLastUpdateTime(new Date());
//		accountTransDetailService.insert(accountTransDetail);
		
		
	}
}
