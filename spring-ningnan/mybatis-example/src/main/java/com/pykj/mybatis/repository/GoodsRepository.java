package com.pykj.mybatis.repository;

import com.pykj.mybatis.entity.Goods;

public interface GoodsRepository {

    public Goods findById(int id);

}
