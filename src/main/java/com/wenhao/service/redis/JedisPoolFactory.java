package com.wenhao.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.wenhao.config.RedisConfig;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class JedisPoolFactory {
	
	@Autowired
	private RedisConfig redisCofig;
	
	@Bean
	public JedisPool jedisFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(redisCofig.getPoolMaxIdle());
		jedisPoolConfig.setMaxTotal(redisCofig.getPoolMaxTotal());
		jedisPoolConfig.setMaxWaitMillis(redisCofig.getPoolMaxIdle() * 1000);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisCofig.getHost(), redisCofig.getPort(), redisCofig.getTimeout() * 1000);
		return jedisPool;
	}
}
