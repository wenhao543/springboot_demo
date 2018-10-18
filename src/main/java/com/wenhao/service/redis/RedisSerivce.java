package com.wenhao.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisSerivce {
	
	@Autowired
	private JedisPool jedisPool;
	
	/**
	 * 设置对象
	 * @param prefix
	 * @param key
	 * @param value
	 * @return
	 */
	public <T> boolean set(KeyPrefix prefix, String key, T value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String str = beanToString(value);
			if(StringUtils.isEmpty(str)) {
				return false;
			}
			String realKey = prefix.getPreifx() + key;
			int seconds = prefix.expireSeconds();
			if(seconds <= 0) {
				jedis.set(realKey, str);
			}else {
				jedis.setex(realKey, seconds, str);
			}
			return true;
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
	
	private <T> String beanToString(T value) {
		if(value == null) {
			return null;
		}
		Class<? extends Object> clazz = value.getClass();
		if(clazz == int.class||clazz == Integer.class) {
			return ""+value;
		}else if(clazz == String.class){
			return (String) value;
		}else if(clazz == long.class||clazz == Long.class) {
			return value+"";
		}else {
			return JSON.toJSONString(value);
		}
	}

	/**
	 * 获取对象
	 * @param prefix
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T> T get(KeyPrefix prefix,String key, Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			//生成真正的key
			String realKey = prefix.getPreifx()+key;
			
			String str = jedis.get(realKey);
			T t = stringToBean(str,clazz);
			return t;
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T stringToBean(String str,Class<T> clazz) {
		if(StringUtils.isEmpty(str) || clazz == null) {
			return null;
		}
		if(clazz == int.class||clazz == Integer.class) {
			return (T) Integer.valueOf(str);
		}else if(clazz == String.class){
			return (T) str;
		}else if(clazz == long.class||clazz == Long.class) {
			return (T) Long.valueOf(str);
		}else {
			return JSON.toJavaObject(JSON.parseObject(str), clazz);
		}
	}
	
	/**
	 * 判断值是否存在
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> boolean exists(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String realKey = prefix.getPreifx()+key;
			return jedis.exists(realKey);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
	
	/**
	 * 增加值
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> Long incr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String realKey = prefix.getPreifx()+key;
			return jedis.incr(realKey);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
	
	/**
	 * 减少值
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> Long decr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String realKey = prefix.getPreifx()+key;
			return jedis.decr(realKey);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
}
