package com.wenhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenhao.dao.MiaoshaOrderMapper;
import com.wenhao.model.Goods;
import com.wenhao.model.MiaoshaOrder;
import com.wenhao.model.OrderInfo;
import com.wenhao.model.TestUser;
import com.wenhao.vo.GoodsVo;

@Service
public class MiaoshaService {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MiaoshaOrderMapper miaoshaOrderMapper;
	
	@Transactional
	public OrderInfo miaosha(TestUser user, GoodsVo goods) {
		goodsService.reduceStock(goods);
		return orderService.createOrder(user,goods);
	}
	
	public MiaoshaOrder getMiaoshaOrderByUserIdAndGoodsId(long userId,long goodsId) {
		MiaoshaOrder order = miaoshaOrderMapper.selectByUserIdAndGoodsId(userId,goodsId);
		return order;
	}
}
