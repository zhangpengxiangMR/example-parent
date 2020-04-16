package com.pykj.mybatis.test;

import com.pykj.mybatis.entity.Classes;
import com.pykj.mybatis.repository.ClassesRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test3 {


    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesRepository classesRepository = sqlSession.getMapper(ClassesRepository.class);

        System.out.println("====查询====");
        Classes classes = classesRepository.findById(1);
        System.out.println(classes);
    }

}
