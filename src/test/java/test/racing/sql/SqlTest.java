package test.racing.sql;

import com.racing.model.system.Menu;
import com.racing.sql.util.GenerateSqlsentenceUtil;

public class SqlTest {

	public static void main(String[] args) {
		
		System.out.println(GenerateSqlsentenceUtil.generateSqlsentence("T_", Menu.class));
	}
}
