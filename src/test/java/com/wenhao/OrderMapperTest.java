package com.wenhao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.dao.OrderInfoMapper;
import com.wenhao.model.OrderInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Test
	public void inserOrder() {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setGoodsName("iphoneXs");
		orderInfo.setDeliveryAddrId(1l);
		orderInfo.setGoodsCount(1);
		orderInfo.setOrderChannel((byte) 2);
		orderInfo.setStatus((byte)0);
		orderInfo.setUserId(123l);
		long orderId = orderInfoMapper.insert(orderInfo);
		System.out.println(orderId);
	}

}
