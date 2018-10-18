package com.wenhao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.dao.ProductInfoMapper;
import com.wenhao.model.ProductInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterCRUDTests {
	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	@Test
	public void mybatisTest(){
		ProductInfo productInfo = productInfoMapper.selectByPrimaryKey("111111");
		System.out.println(productInfo.toString());
	}
}
