package com.wenhao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenhao.dao.GoodsMapper;
import com.wenhao.dao.MiaoshaGoodsMapper;
import com.wenhao.dto.CodeMsg;
import com.wenhao.exception.GlobalException;
import com.wenhao.model.Goods;
import com.wenhao.model.MiaoshaGoods;
import com.wenhao.vo.GoodsVo;

@Service
public class GoodsService {
	
	@Autowired
	private MiaoshaGoodsMapper goodsMapper;
	
	public List<GoodsVo> listGoodsVo(){
		List<GoodsVo> GoodsVoList = goodsMapper.selectGoodsList();
		return GoodsVoList;
	}
	
	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		GoodsVo goodsVo = goodsMapper.selectGoodsByGoodsId(goodsId);
		return goodsVo;
	}

	public void reduceStock(GoodsVo goods) {
		int index = goodsMapper.reduceStock(goods.getId());
		if(index != 1) {
			throw new GlobalException(CodeMsg.REDUCE_GOODS_FAIL);
		}
	}

}
