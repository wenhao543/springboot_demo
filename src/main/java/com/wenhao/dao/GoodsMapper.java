package com.wenhao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wenhao.model.Goods;

@Mapper
public interface GoodsMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Long id);

    int update(Goods record);
}