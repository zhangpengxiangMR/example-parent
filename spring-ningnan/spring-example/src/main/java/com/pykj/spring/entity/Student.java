package com.pykj.spring.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    private Long id ;
    private String name;
    private Integer age;
    private Address address;
    private List<Hobby> hobbyList;
    {
        System.out.println("我是不添加static的静态方法");
    }

    static {
        System.out.println("我是静态方法");
    }

    public Student() {
        System.out.println("创建对象");
    }

    /*public Student(Long id, String name, Integer age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }*/
}
