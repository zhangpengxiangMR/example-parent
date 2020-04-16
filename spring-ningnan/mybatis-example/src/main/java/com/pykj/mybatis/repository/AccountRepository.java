package com.pykj.mybatis.repository;

import com.pykj.mybatis.entity.Account;

import java.util.List;

public interface AccountRepository {

    public int save(Account account);

    public int update(Account account);

    public int deleteById(int id);

    public List<Account> findAll();

    public Account findById(int id);

}
