package com.pykj.example.repository;

import com.pykj.example.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    public Customer findById(int id);

    public List<Customer> findAll();

}
