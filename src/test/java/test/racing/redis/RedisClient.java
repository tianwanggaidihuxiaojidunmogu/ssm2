package test.racing.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.racing.redis.serializable.RedisObjectSerializable;

public class RedisClient {

	public static void main(String[] args) throws Exception{
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(10000);
		config.setTestOnBorrow(false);
		JedisPool jedisPool=new JedisPool(config, "10.1.200.122", 6379,10000,"redis");
		
		Jedis jedis=jedisPool.getResource();
		Test test=new Test();
		test.setName("username");
		test.setEmail("aaa@qq.com");
		RedisObjectSerializable redisObjectSerializable=new RedisObjectSerializable(jedis);
		System.out.println(redisObjectSerializable.setObject(test));
		
		Test t=redisObjectSerializable.getSerializableObject("username", Test.class);
		System.out.println(t.getName());
		System.out.println(t.getEmail());
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		ObjectOutputStream oos = new ObjectOutputStream(bos);
//		oos.writeObject(test);
//		jedis.set("object".getBytes("utf-8"), bos.toByteArray());
//		bos.close();
//		oos.close();
//		
		
//		byte[] bytes=jedis.get("object".getBytes("utf-8"));
//		ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
//		ObjectInputStream ois=new ObjectInputStream(bis);
//		
//		Test t=(Test) ois.readObject();
//		System.out.println(t.getName());
//		System.out.println(t.getEmail());
//		bis.close();
//		ois.close();
		
//		System.out.println(jedis.lpush("userList", "aaa","bbb","ccc","ddd","eee","fff"));
		//		jedis.lset("userList", 1, "Nick Xu");
//		for (int i = 0; i < 20; i++) {
//			jedis.lset(list_key, i, String.valueOf(i));
//		}
//		jedis.lpop("userList");
//		List<String> list=jedis.lrange("userList", 0, jedis.llen("userList"));
//		List<String> list=jedis.lrange("userList", 0, 17);
//		for(String value:list){
//			System.out.println(value);
//		}
//		Set<String> keys=jedis.keys("*");
//		System.out.println(keys.size());
//		String key="";
//		for(Iterator<String> it=keys.iterator();it.hasNext();key=it.next()){
//			System.out.println(String.format("key:%s，value:%s", key,jedis.get(key)));
//			jedis.del(key);
//		}
	}

}
