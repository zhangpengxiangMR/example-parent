package com.pykj.mybatis.repository;

import com.pykj.mybatis.entity.Student;

public interface StudengRepository {

    public Student findById(int id);

    public Student findByIdLazy(int id);

}
