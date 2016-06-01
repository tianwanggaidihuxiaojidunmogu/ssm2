package com.racing.redis.provider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;

import com.racing.redis.annotation.RedisKey;
import com.racing.redis.exception.RedisException;
import com.racing.redis.serializable.ObjectSerializable;

/**
 * Redis 对象存储
 * 
 * @author liupeng
 */
public class RedisObjectProvider implements RedisProvider {

	private final String DEFAULT_CHARSET = "UTF-8";

	public RedisObjectProvider() {

	}

	public RedisObjectProvider(Jedis jedis) {
		this.jedis = jedis;
	}

	private Jedis jedis;

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	public String setObject(String key, Object object) {
		return jedis.set(key.getBytes(Charset.forName(DEFAULT_CHARSET)), ObjectSerializable.serializable(object));
	}

	public String setObject(Object object) {
		Class<?> clazz = object.getClass();
		String fieldKey = null;
		for (Field field : clazz.getDeclaredFields()) {
			if (field.getAnnotation(RedisKey.class) != null) {
				fieldKey = field.getName();
				break;
			}
		}

		if (fieldKey == null) {
			throw new RedisException("not found redis key,please set redis key!");
		}

		String getMethodName = "get".concat(fieldKey.substring(0, 1).toUpperCase()).concat(fieldKey.substring(1));
		Method getMethod = null;
		try {
			getMethod = clazz.getDeclaredMethod(getMethodName);
		} catch (Exception e) {

		}
		if (getMethod == null) {
			throw new RedisException(String.format("this method <%s> can be not parameter!", getMethodName));
		}
		if (getMethod.getReturnType() != null && !getMethod.getReturnType().equals(String.class)) {
			throw new RedisException(String.format("this method <%s> returnType must be java.lang.String!", getMethodName));
		}
		String key = null;
		try {
			key = (String) getMethod.invoke(object);
		} catch (Exception e) {

		}

		if (StringUtils.isEmpty(key)) {
			throw new RedisException(String.format("this filed<%s> can not be null!", fieldKey));
		}

		return jedis.set(key.getBytes(Charset.forName(DEFAULT_CHARSET)), ObjectSerializable.serializable(object));
	}

	public <T> T getSerializableObject(String key, Class<T> clazz) {
		return ObjectSerializable.deserializable(jedis.get(key.getBytes(Charset.forName(DEFAULT_CHARSET))), clazz);
	}
}
