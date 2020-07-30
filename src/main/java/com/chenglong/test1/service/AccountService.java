package com.chenglong.test1.service;

import com.chenglong.test1.entities.Account;

import java.util.List;

public interface AccountService {
    public void addAccount(Account account);

    Account getAccount(String id);

    List<Account> getAccounts();

    public void updateAccount(Account account);

    public void deleteAccount(String id);
}
