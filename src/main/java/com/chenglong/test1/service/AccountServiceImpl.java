package com.chenglong.test1.service;

import com.chenglong.test1.entities.Account;
import com.chenglong.test1.exception.BusinessException;
import com.chenglong.test1.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Resource
    private AccountMapper accountMapper;

//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    @Override
    @Transactional
    public void addAccount(Account account){
        accountMapper.insert(account);
    }

    @Override
    public Account getAccount(String id) {
        return accountMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public List<Account> getAccounts() {
        return accountMapper.selectAll();
    }

    @Override
    @Transactional
    public void updateAccount(Account account) {
        int i = accountMapper.updateByPrimaryKey(account);
        if(i != 1){
            throw new BusinessException("4000", "更新失败");
        }
    }

    @Override
    public void deleteAccount(String id) {
        int i = accountMapper.deleteByPrimaryKey(Integer.valueOf(id));
        if(i != 1){
            throw new BusinessException("4000", "删除失败");
        }
    }
}
