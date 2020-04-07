package com.pykj.example.test;

import com.pykj.example.entity.Customer;
import com.pykj.example.repository.CustomerRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test4 {


    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);

        System.out.println("====查询====");
        Customer customer = customerRepository.findById(1);
        System.out.println(customer);
        System.out.println("====查询全部====");
        List<Customer> customerList =  customerRepository.findAll();
        for (Customer c:customerList) {
            System.out.println(c);
        }
    }

}
