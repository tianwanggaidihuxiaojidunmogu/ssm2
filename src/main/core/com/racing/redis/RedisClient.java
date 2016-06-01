package com.racing.redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

	public static void main(String[] args) {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(10000);
		config.setTestOnBorrow(false);
		JedisPool jedisPool=new JedisPool(config, "10.1.200.122", 6379,10000,"redis");
		
		Jedis jedis=jedisPool.getResource();
		Set<String> keys=jedis.keys("*");
		
		String key="";
		for(Iterator<String> it=keys.iterator();it.hasNext();key=it.next()){
			System.out.println(String.format("key:%s", key));
			System.out.println(jedis.get(key));
		}
		
	}
}
