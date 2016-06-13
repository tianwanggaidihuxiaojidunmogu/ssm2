package com.racing.sql.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.racing.commons.StringUtil;
import com.racing.sql.DBField;
import com.racing.sql.DBIndex;
import com.racing.sql.DBNotNull;
import com.racing.sql.DBTable;


/**
 * 根据实体的注解生成创建表脚本（包含异常表脚本）
 * 
 * @author liupeng
 */
public class GenerateSqlsentenceUtil {
	public static String generateDropTableSqlsentence(String prefix,Class<?> clazz){
		StringBuffer dropTableSentence=new StringBuffer();
		String tableName = prefix.concat(clazz.getSimpleName().toUpperCase());
		dropTableSentence.append("DECLARE \r\n");
		dropTableSentence.append("NUM NUMBER; \r\n");
		dropTableSentence.append("BEGIN \r\n");
		dropTableSentence.append("	SELECT COUNT(1) \r\n");
		dropTableSentence.append("	INTO   NUM ");
		dropTableSentence.append("	FROM   ALL_TABLES \r\n");
		dropTableSentence.append("	WHERE  TABLE_NAME = '"+tableName+"'; \r\n");
		dropTableSentence.append("	IF NUM = 1 THEN \r\n");
		dropTableSentence.append("		EXECUTE IMMEDIATE 'drop table "+tableName+"'; \r\n");
		dropTableSentence.append("	END IF; \r\n");
		dropTableSentence.append("END; \r\n");
		return dropTableSentence.toString();
	}

	public static String generateSqlsentence(String prefix,Class<?> clazz) {
		StringBuffer createSqlSentence = new StringBuffer();
		StringBuffer commentSqlSentence = new StringBuffer();

		String tableName = prefix.concat(clazz.getSimpleName().toUpperCase());
		DBTable tableAnnotation = clazz.getAnnotation(DBTable.class);
		String comment = tableAnnotation == null ? "" : tableAnnotation.remark();

		List<Field> fieldList = new ArrayList<Field>();
		fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));

		while (clazz.getSuperclass() != null && !clazz.getName().equals(Object.class.getName())) {
			fieldList.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		commentSqlSentence.append(String.format("comment on table %s is '%s';\r\n", tableName, comment).toUpperCase());
		createSqlSentence.append(String.format("CREATE TABLE %s(\r\n", tableName));
		for (int index = 0; index < fieldList.size(); index++) {
			DBField dbFieldAnnotation = fieldList.get(index).getAnnotation(DBField.class);
			DBIndex dbIndexAnnotation = fieldList.get(index).getAnnotation(DBIndex.class);
			DBNotNull dbNotNullAnnotation = fieldList.get(index).getAnnotation(DBNotNull.class);
			if (dbFieldAnnotation != null) {
				String table_column_name = getTableCloumnName(dbFieldAnnotation.name(), fieldList.get(index).getName());
				String table_column_type = dbFieldAnnotation.type();
				int table_column_length = dbFieldAnnotation.length();
				int table_column_precision = dbFieldAnnotation.precision();
				String table_column_remark = dbFieldAnnotation.remark();

				String type = getType(table_column_type, table_column_length, table_column_precision).toUpperCase();
				String is_not_null_str = dbNotNullAnnotation != null ? " NOT NULL" : "";
				String primary_key_str = dbIndexAnnotation != null ? " PRIMARY KEY" : "";
				String column_sentence = String.format("%s %s%s%s", table_column_name, type, is_not_null_str, primary_key_str);
				createSqlSentence.append(column_sentence);
				if (index < fieldList.size() - 1) {
					createSqlSentence.append(",\r\n");
				}
				commentSqlSentence.append(String.format("comment on column %s.%s is '%s';\r\n", tableName, table_column_name, table_column_remark).toUpperCase());
			}

		}
		createSqlSentence.append(");\r\n");
		createSqlSentence.append(commentSqlSentence);

		return createSqlSentence.toString();
	}

	public static String generateErrorSqlsentence(Class<?> clazz) {
		StringBuffer createSqlSentence = new StringBuffer();
		StringBuffer commentSqlSentence = new StringBuffer();

		String tableName = "ERROR_".concat(clazz.getSimpleName().toUpperCase());
		DBTable tableAnnotation = clazz.getAnnotation(DBTable.class);
		String comment = tableAnnotation == null ? "" : tableAnnotation.remark();

		List<Field> fieldList = new ArrayList<Field>();
		fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));

		while (clazz.getSuperclass() != null && !clazz.getName().equals(Object.class.getName())) {
			fieldList.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		commentSqlSentence.append(String.format("comment on table %s is '%s';\r\n", tableName, comment).toUpperCase());
		createSqlSentence.append(String.format("CREATE TABLE %s(\r\n", tableName));
		for (int index = 0; index < fieldList.size(); index++) {
			DBField dbFieldAnnotation = fieldList.get(index).getAnnotation(DBField.class);
			DBIndex dbIndexAnnotation = fieldList.get(index).getAnnotation(DBIndex.class);
			if (dbFieldAnnotation != null) {
				String table_column_name = getTableCloumnName(dbFieldAnnotation.name(), fieldList.get(index).getName());
				String table_column_type = dbFieldAnnotation.type();
				int table_column_length = dbFieldAnnotation.length();
				int table_column_precision = dbFieldAnnotation.precision();
				String table_column_remark = dbFieldAnnotation.remark();
				if ("VARCHAR2".equals(table_column_type)) {
					table_column_length = 2000;
				}

				String type = getType(table_column_type, table_column_length, table_column_precision).toUpperCase();
				String primary_key_str = dbIndexAnnotation != null ? " PRIMARY KEY" : "";
				String column_sentence = String.format("%s %s%s%s", table_column_name, type, "", primary_key_str);
				createSqlSentence.append(column_sentence);
				if (index < fieldList.size() - 1) {
					createSqlSentence.append(",\r\n");
				}
				commentSqlSentence.append(String.format("comment on column %s.%s is '%s';\r\n", tableName, table_column_name, table_column_remark).toUpperCase());
			}

		}
		createSqlSentence.append(");\r\n");
		createSqlSentence.append(commentSqlSentence);

		return createSqlSentence.toString();
	}

	private static String getType(String table_column_type, int table_column_length, int table_column_precision) {
		if (table_column_length == 0) {
			return table_column_type;
		} else if (table_column_precision == 0) {
			return String.format("%s(%d)", table_column_type, table_column_length);
		} else {
			return String.format("%s(%d,%d)", table_column_type, table_column_length, table_column_precision);
		}
	}

	private static String getTableCloumnName(String column_name, String field_name) {
		if (column_name.length() != 0)
			return column_name;
		return StringUtil.convertCamel(field_name, "_").toUpperCase();
	}

}
