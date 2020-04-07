package com.pykj.example.test;

import com.pykj.example.entity.Account;
import com.pykj.example.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        System.out.println("====新增====");
       /* Account accountSave = new Account(1,"王五","a123456",18);
        accountRepository.save(accountSave);
        sqlSession.commit();*/
        System.out.println("====更新====");
       /*Account accountUpdate = new Account(4,"1","1",18);
       accountRepository.update(accountUpdate);
       sqlSession.commit();*/
        System.out.println("====删除====");
        accountRepository.deleteById(4);
        sqlSession.commit();
        System.out.println("====查询全部====");
        List<Account> all = accountRepository.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        System.out.println("====查询一条数据====");
        Account byId = accountRepository.findById(4);
        if(byId != null){
            System.out.println(byId);
        }
        sqlSession.close();
    }

}
