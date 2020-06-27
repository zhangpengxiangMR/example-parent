package com.pykj.design.principle.openclosed.example;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/18 22:49
 */
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    /*public Double getOriginPrice() {
        return super.getPrice();
    }*/

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }


}
