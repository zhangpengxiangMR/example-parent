package com.pykj.mybatis.repository;

import com.pykj.mybatis.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    public Customer findById(int id);

    public List<Customer> findAll();

}
