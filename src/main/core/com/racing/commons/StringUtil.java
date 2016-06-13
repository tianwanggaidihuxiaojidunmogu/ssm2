/* Created on 2006-7-21 */
package com.racing.commons;

import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * String related utilities
 * 
 * @author david.zhang
 */
public abstract class StringUtil {

	public static boolean isEmpty(String string) {
		return StringUtils.isEmpty(string);
	}

	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}

	/**
	 * Replace place holder with parameters
	 * 
	 * @param template
	 * @param values
	 * @return
	 */
	public static String replacePlaceHolder(String template, Map<String, String> valueMap) {

		if (template.indexOf("${") == -1) {
			return template;
		}

		while (true) {
			int start = template.indexOf("${");
			int end = template.indexOf("}", start);

			if (start != -1 && end != -1) {
				String temp = template.substring(start + 2, end);

				if (valueMap.keySet().contains(temp)) { // contains the dynamic
					// string then replace
					template = template.substring(0, start) + (String) valueMap.get(temp) + template.substring(end + 1);
				} else {
					template = template.substring(0, start) + template.substring(end + 1);
				}

			} else {
				break;
			}
		}

		return template;
	}

	/**
	 * @param value
	 * @param spliter
	 * @param arrIndex
	 *            从0开始
	 * @return
	 */
	public static String subString(String value, String spliter, String repSpliter, int arrIndex) {
		String[] values = value.split(spliter);
		StringBuilder stringBuilder = new StringBuilder();
		for (int index = 0; index < values.length; index++) {
			if (index >= arrIndex) {
				if (index == values.length - 1) {
					stringBuilder.append(values[index]);
				} else {
					stringBuilder.append(values[index]).append(repSpliter);
				}
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Determine a template has a placeHolder
	 * 
	 * @param template
	 * @return
	 */
	public static boolean hasPlaceHolder(String template) {
		if (template.indexOf("${") == -1) {
			return false;
		} else {
			return true;
		}
	}

	public static String generateParameterKey(String parameterKey) {
		if (parameterKey != null && !parameterKey.isEmpty()) {
			StringBuffer sb = new StringBuffer("");
			String[] temp = parameterKey.split("\\.");
			for (int i = 0; i < temp.length; i++) {
				if (sb.toString().length() == 0) {
					sb.append(temp[0]);
				} else
					sb.append(temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1));
			}
			return sb.toString();
		}
		return null;
	}

	/**
	 * Connect strings together
	 * 
	 * @param parts
	 * @return
	 */
	public static String connect(String... parts) {
		StringBuilder sb = new StringBuilder();
		for (String part : parts) {
			sb.append(part);
		}
		return sb.toString();
	}

	/**
	 * Convert camel naming to any naming using seperator
	 * 
	 * @param template
	 * @param seperator
	 * @return
	 */
	public static String convertCamel(String template, String seperator) {
		StringBuffer result = new StringBuffer();
		if (template != null && template.length() > 0) {
			result.append(template.substring(0, 1).toLowerCase());
			for (int i = 1; i < template.length(); i++) {

				String s = template.substring(i, i + 1);
				if (Character.isLowerCase(template.charAt(i))) {
					result.append(s);
				} else {
					if (("D").equals(template.substring(i, i + 1)) && ("I").equals(template.substring(i - 1, i))) {
						result.append(s);
					} else if (("_").equals(template.charAt(i))) {
						continue;
					} else if (Character.isDigit(template.charAt(i))) {
						result.append(s);
					} else {
						result.append(seperator);
						result.append(s.toLowerCase());
					}
				}
			}
		}
		return result.toString();
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static String trim(String string) {
		return string.trim();
	}

	public static void main(String[] args) {
		System.out.println(subString("eq.detail.orderDetail", "\\.", ".", 2));
	}
}
