package com.racing.commons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DBUtil {

	private static final Logger logger = Logger.getLogger(DBUtil.class);

	public static List<Map<String, String>> executeQuery(String sqlSentence, String host, String port, String username, String password, String orcl) throws Exception {
		logger.info("execute sql->" + sqlSentence);
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		String conn_str = "oracle.jdbc.driver.OracleDriver";
		String url = String.format("jdbc:oracle:thin:@%s:%s:%s", host, port, orcl);
		Class.forName(conn_str);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sqlSentence);
		ResultSetMetaData metas = rs.getMetaData();
		String columns[] = new String[metas.getColumnCount()];

		for (int i = 0; i < metas.getColumnCount(); i++) {
			columns[i] = metas.getColumnName(i + 1);
		}
		while (rs.next()) {
			Map<String, String> value = new HashMap<String, String>();
			for (int i = 0; i < columns.length; i++) {
				value.put(columns[i].toUpperCase(), rs.getString(columns[i]));
			}
			result.add(value);
		}

		rs.close();
		stm.close();
		conn.close();
		return result;
	}

	public static boolean executeSql(String sqlSentence, String host, String port, String username, String password, String orcl) {
		String conn_str = "oracle.jdbc.driver.OracleDriver";
		String url = String.format("jdbc:oracle:thin:@%s:%s:%s", host, port, orcl);
		Connection conn = null;
		Statement stm = null;
		boolean isflag = false;
		try {
			Class.forName(conn_str);
			conn = DriverManager.getConnection(url, username, password);
			stm = conn.createStatement();
			isflag = stm.execute(sqlSentence);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isflag;
	}

	public static void main(String[] args) throws Exception {
		List<Map<String, String>> list = DBUtil.executeQuery("select * from BATCH_INFO t", "192.168.21.188", "1521", "odsquery", "odsquery", "fayuan");

		for (Iterator<Map<String, String>> it = list.iterator(); it.hasNext();) {
			Map<String, String> map = it.next();
			System.out.println(map.get("MEMO"));
		}
	}

}
