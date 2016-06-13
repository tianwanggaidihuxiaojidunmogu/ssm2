package test.racing.trans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.racing.model.system.Menu;
import com.racing.service.schedule.ScheduleService;
import com.racing.service.system.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:context/spring-config.xml","classpath:context/spring-mybatis.xml"})
public class MtbatisTest {

	@Autowired
	MenuService menuService;
	
	@Autowired
	ScheduleService scheduleService;
	
	@Test
	public void insert(){
//		Schedule schedule=new Schedule();
//		schedule.setJobId("asdaf");
//		schedule.setJobClass("asdasd");
//		schedule.setJobCron("aaa");
//		schedule.setJobGroup("");
//		scheduleService.insert(schedule);

		Menu menu = new Menu();
		menu.setId(1);
		menu.setLevl(1);
		menu.setName("系统菜单");
		menu.setParent(0);
		menu.setSeq(1);
		menu.setUrl("#");
		menuService.insert(menu);
		
	}
}
