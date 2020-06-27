package com.pykj.gupao.application.reflection.demo1;

import java.lang.reflect.Method;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/22 22:36
 */
public class Dog {

    public String color;

    public void bark(){
        System.out.println("Dog barking");
    }

    public static void main(String[] args) throws Exception {
        Class clazz = Dog.class;
        //反射获取一个对象
        Dog dog = (Dog)clazz.newInstance();
        //获取父类
        System.out.println(clazz.getSuperclass());
        //获取classLoader
        System.out.println(clazz.getClassLoader());
        //获取类的包名
        System.out.println(clazz.getPackage());
        //获取全路径
        System.out.println(clazz.getName());
        //获取类名
        System.out.println(clazz.getSimpleName());
        Method method = clazz.getDeclaredMethod("bark");
        method.invoke(clazz.newInstance());

    }

}
