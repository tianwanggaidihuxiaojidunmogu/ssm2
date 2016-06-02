package com.racing.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisConfig {
	@Value("${redis.pool.maxActive}")
	private String maxActive;
	@Value("${redis.pool.maxIdle}")
	private String maxIdle;
	@Value("${redis.pool.maxWait}")
	private String maxWait;
	@Value("${redis.pool.testOnBorrow}")
	private String testObBorrow;
	@Value("${redis.host}")
	private String host;
	@Value("${redis.port}")
	private String port;
	@Value("${redis.password}")
	private String password;

	public JedisPoolConfig getConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(Integer.parseInt(this.maxActive));
		config.setMaxIdle(Integer.parseInt(this.getMaxIdle()));
		config.setMaxWaitMillis(Long.parseLong(this.maxWait));
		config.setTestOnBorrow("true".equals(this.testObBorrow));
		return config;
	}

	public JedisPool getJedisPool() {
		JedisPool jedisPool = new JedisPool(getConfig(), this.host, Integer.parseInt(this.port), 10000, this.password);
		return jedisPool;
	}

	public String getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	public String getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}

	public String getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}

	public String isTestObBorrow() {
		return testObBorrow;
	}

	public void setTestObBorrow(String testObBorrow) {
		this.testObBorrow = testObBorrow;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
