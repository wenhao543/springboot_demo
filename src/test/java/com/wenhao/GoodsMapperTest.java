package com.wenhao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.dao.MiaoshaGoodsMapper;
import com.wenhao.model.MiaoshaGoods;
import com.wenhao.vo.GoodsVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTest {
	
	@Autowired
	private MiaoshaGoodsMapper miaoshaGoodsMapper;

	@Test
	public void selectListGoods() {
		List<GoodsVo> goodsVoList = miaoshaGoodsMapper.selectGoodsList();
		for(GoodsVo goodsVo:goodsVoList) {
			BigDecimal miaoshaoPrice = goodsVo.getMiaoshaoPrice();
			System.out.println(miaoshaoPrice.toString());
		}
	}
	
	@Test
	public void selectByPrimaryKey() {
		GoodsVo goods = miaoshaGoodsMapper.selectByPrimaryKey(1l);
		System.out.println(goods.toString());
	}
}
