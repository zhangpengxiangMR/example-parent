package com.pykj.design.principle.liskovsubstiution.test;

import com.pykj.design.principle.liskovsubstiution.example.Rectangle;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 18:19
 */
public class Test {

    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() >= rectangle.getHeight()) {
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("width:" + rectangle.getWidth() + "height:" + rectangle.getHeight());
        }
        System.out.println("方法结束:" + "width:" + rectangle.getWidth() + "height:" + rectangle.getHeight());
    }

    public static void main(String[] args) {
        /*Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        resize(rectangle);*/
        //输出结果发现高比宽还大了，这在长方形中是一种非常正常的情况。
        //把Rectangle类替换成它的子类Square
        /*Square square = new Square();
        square.setLength(10);
        resize(square);*/
        //上述代码替换后出现死循环，违背了里氏替换原则。将父类替换子类后，程序运行结果没有达到预期。
        //因此，代码设计存在一定的风险。
        //里氏替换原则只存在于父类与子类之间，约束继承泛滥。

    }

}
