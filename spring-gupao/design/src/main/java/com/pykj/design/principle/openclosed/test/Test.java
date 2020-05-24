package com.pykj.design.principle.openclosed.test;

import com.pykj.design.principle.openclosed.example.ICourse;
import com.pykj.design.principle.openclosed.example.JavaCourse;
import com.pykj.design.principle.openclosed.example.JavaDiscountCourse;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/18 22:37
 */
public class Test {

    public static void main(String[] args) {
        ICourse javaCourse = new JavaCourse(1,"java",100.00);
        System.out.println(javaCourse.getPrice());

        JavaDiscountCourse javaDiscountCourse = new JavaDiscountCourse(1,"java",100.00);
        System.out.println("原始价格：" + javaDiscountCourse.getPrice()+",折扣价格：" + javaDiscountCourse.getDiscountPrice());

    }

}
