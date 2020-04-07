package com.pykj.example.repository;

import com.pykj.example.entity.Student;

public interface StudengRepository {

    public Student findById(int id);

    public Student findByIdLazy(int id);

}
