package com.chenglong.test1.mapper;

import com.chenglong.test1.entities.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectAll();

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}