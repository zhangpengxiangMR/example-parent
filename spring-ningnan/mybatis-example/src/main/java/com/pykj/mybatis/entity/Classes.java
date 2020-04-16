package com.pykj.mybatis.entity;

import java.util.List;

public class Classes {

    private int id;
    private String name;
    private List<Student> studentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
