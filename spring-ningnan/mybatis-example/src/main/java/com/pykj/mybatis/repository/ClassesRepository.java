package com.pykj.mybatis.repository;

import com.pykj.mybatis.entity.Classes;

public interface ClassesRepository {

    public Classes findById(int id);

    public Classes findByIdLazy(int id);
}
