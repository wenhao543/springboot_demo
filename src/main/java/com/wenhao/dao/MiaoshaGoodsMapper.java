package com.wenhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wenhao.model.MiaoshaGoods;
import com.wenhao.vo.GoodsVo;
@Mapper
public interface MiaoshaGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MiaoshaGoods record);

    int insertSelective(MiaoshaGoods record);

    GoodsVo selectByPrimaryKey(Long id);
    
    GoodsVo selectGoodsByGoodsId(Long Id);

    int updateByPrimaryKeySelective(MiaoshaGoods record);

    int updateByPrimaryKey(MiaoshaGoods record);
    
    List<GoodsVo> selectGoodsList();

	int reduceStock(Long id);
}