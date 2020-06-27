package com.pykj.mybatis.test;

import com.pykj.mybatis.entity.Account;
import com.pykj.mybatis.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 一级缓存、二级缓存
 */
public class Test7 {

    public static void main(String[] args) {
        InputStream inputStream = Test7.class.getResourceAsStream("/mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account = accountRepository.findById(1);
        System.out.println("第一次查询：" + account);
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();
        accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account1 = accountRepository.findById(1);
        System.out.println("第二次查询：" + account1);
    }

}
