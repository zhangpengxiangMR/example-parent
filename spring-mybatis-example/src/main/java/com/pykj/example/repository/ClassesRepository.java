package com.pykj.example.repository;

import com.pykj.example.entity.Classes;

public interface ClassesRepository {

    public Classes findById(int id);

    public Classes findByIdLazy(int id);
}
