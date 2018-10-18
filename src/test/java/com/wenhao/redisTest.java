package com.wenhao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.dao.ProductInfoMapper;
import com.wenhao.model.ProductInfo;
import com.wenhao.service.redis.RedisSerivce;
import com.wenhao.service.redis.key.UserKey;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTest {
	
	@Autowired
	private RedisSerivce redisServie;
	
	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	@Test
	public void getRedis() {
//		redisServie.
	}
	
	@Test
	public void setRedis() {
		ProductInfo productInfo = productInfoMapper.selectByPrimaryKey("111111");
		boolean index = redisServie.set(UserKey.getById,"sp", productInfo);
		
		System.out.println(index);
		
		ProductInfo productInfo2 = redisServie.get(UserKey.getById,"sp", ProductInfo.class);
		System.out.println(productInfo2.toString());
	}

}
