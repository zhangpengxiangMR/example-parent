package com.pykj.ykz.chapter4.aspect.pojo;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/22 1:11
 */
public class Person {

    private Long id ;

    private String name ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
