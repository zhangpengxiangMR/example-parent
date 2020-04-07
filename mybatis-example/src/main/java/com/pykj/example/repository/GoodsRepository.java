package com.pykj.example.repository;

import com.pykj.example.entity.Goods;

public interface GoodsRepository {

    public Goods findById(int id);

}
