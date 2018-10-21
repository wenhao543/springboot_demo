package com.wenhao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.wenhao.model.OrderInfo;
@Mapper
public interface OrderInfoMapper {
    int deleteByPrimaryKey(Long id);

//    @SelectKey(keyProperty = "id", before = false, resultType = java.lang.Long.class, statement = { "SELECT LAST_INSERT_ID() AS ID" })
    long insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int update(OrderInfo record);
}