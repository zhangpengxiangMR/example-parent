package com.pykj.mybatis.test;

import com.pykj.mybatis.entity.Student;
import com.pykj.mybatis.repository.StudengRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test6 {


    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudengRepository studengRepository = sqlSession.getMapper(StudengRepository.class);

        System.out.println("====查询====");
        Student byId = studengRepository.findByIdLazy(1);
        System.out.println(byId.getClasses());
    }

}
