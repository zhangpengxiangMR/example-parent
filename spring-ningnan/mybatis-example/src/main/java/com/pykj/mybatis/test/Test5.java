package com.pykj.mybatis.test;

import com.pykj.mybatis.entity.Goods;
import com.pykj.mybatis.repository.GoodsRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test5 {


    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsRepository goodsRepository = sqlSession.getMapper(GoodsRepository.class);

        System.out.println("====查询====");
        Goods goods = goodsRepository.findById(1);
        System.out.println(goods);

    }

}
