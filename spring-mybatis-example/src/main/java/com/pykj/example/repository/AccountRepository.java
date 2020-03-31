package com.pykj.example.repository;

import com.pykj.example.entity.Account;

import java.util.List;

public interface AccountRepository {

    public int save(Account account);

    public int update(Account account);

    public int deleteById(int id);

    public List<Account> findAll();

    public Account findById(int id);

}
