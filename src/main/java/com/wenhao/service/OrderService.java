package com.wenhao.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenhao.dao.MiaoshaOrderMapper;
import com.wenhao.dao.OrderInfoMapper;
import com.wenhao.model.MiaoshaGoods;
import com.wenhao.model.MiaoshaOrder;
import com.wenhao.model.OrderInfo;
import com.wenhao.model.TestUser;
import com.wenhao.utils.SequenceUtil;
import com.wenhao.vo.GoodsVo;

@Service
public class OrderService {
	
	@Autowired
	private MiaoshaOrderMapper miaoshaOrderMapper;
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Autowired
	private GoodsService goodsService;

	@Transactional
	public OrderInfo createOrder(TestUser user, GoodsVo goods) {
		OrderInfo orderInfo = new OrderInfo();
		long id = new SequenceUtil(1l, 1l).nextId();
		orderInfo.setCreateDate(new Date());
		orderInfo.setDeliveryAddrId(0l);
		orderInfo.setGoodsId(goods.getId());
		orderInfo.setGoodsCount(1);
		orderInfo.setGoodsName(goods.getGoodsName());
		orderInfo.setStatus((byte) 0);
		orderInfo.setId(id);
		orderInfo.setUserId(user.getId());
		orderInfo.setGoodsPrice(goods.getMiaoshaoPrice());
		
		orderInfoMapper.insert(orderInfo);
		
		MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
		miaoshaOrder.setGoodsId(goods.getId());
		miaoshaOrder.setOrderId(id);
		miaoshaOrder.setUserId(user.getId());
		
		miaoshaOrderMapper.insert(miaoshaOrder);
		
		return orderInfo;
	}

}
