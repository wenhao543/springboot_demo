package com.wenhao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wenhao.model.TestUser;

@Mapper
public interface TestUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);
}