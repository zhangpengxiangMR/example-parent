package com.pykj.gupao.application.reflection.demo3;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/22 23:07
 */
@Slf4j
public class Main {


    public static void main(String[] args) throws Exception {
        constructorOper();
        //methodOper();
        //fieldOper();
        //basicOper();
    }

    //类的基本操作
    public static void  basicOper() throws Exception{
        //获取Class对象的4种方法
        Class clazz = Boy.class;
        Class clazz1 = new Boy().getClass();
        Class clazz2 = Class.forName("com.pykj.gupao.application.reflection.demo3.Boy");
        Class clazz3 = Main.class.getClassLoader().loadClass("com.pykj.gupao.application.reflection.demo3.Boy");
        //获取类的访问、权限修饰符
        int modifiers = clazz.getModifiers();
        System.out.println("modifiers:" + modifiers);
        //获取类的包名
        Package aPackage = clazz.getPackage();
        System.out.println("Package:" + aPackage.getName());
        //获取类的全路径名称
        String name = clazz.getName();
        System.out.println("name:" + name);
        //获取类的名称
        String simpleName = clazz.getSimpleName();
        System.out.println("simpleName:" + simpleName);
        //获取类的加载器
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("classLoader:" + classLoader);
        //获取类的接口
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("interfaces:" + Arrays.toString(interfaces));
        //获取类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println("superclass:" + superclass.getName());
        //获取类的注解
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("annotations:" + Arrays.toString(annotations));
    }

    //字段操作
    public static void fieldOper() throws Exception {
        Class clazz = Boy.class;
        Boy boy = (Boy)clazz.newInstance();
        //获取本类公有字段包含继承公有字段
        Field[] fields = clazz.getFields();
        System.out.println(Arrays.toString(fields));
        for (int i =0;i<fields.length;i++) {
            System.out.println("公有字段修饰符：" + fields[i].getModifiers() + ",字段名称："+fields[i].getName()+",type:"+fields[i].getType());
        }
        //获取类的公有字段
        Field name = clazz.getField("name");
        name.set(boy,"names");
        System.out.println("获取类的公有字段：" + name.getName());
        System.out.println("-----------------------------------------------------------------------------------------");
        //获取本类的所有字段
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        for (int i = 0;i<declaredFields.length;i++) {
            System.out.println("私有字段修饰符：" + declaredFields[i].getModifiers() + ",字段名称："+declaredFields[i].getName()+",type:"+declaredFields[i].getType());
        }
        //获取私有字段
        Field weight = clazz.getDeclaredField("weight");
        System.out.println("获取私有字段：" + weight.getName());
        weight.setAccessible(true);
        weight.set(boy,1);
        System.out.println("-----------------------------------------------------------------------------------------");
        //静态字段赋值可以不指定Object
        Field boys = clazz.getField("boys");
        boys.set(null,"boysssssssssssss");
        System.out.println(boys.getName());
    }

    public static  void methodOper() throws Exception {
        Class clazz = Boy.class;
        Boy boy = (Boy)clazz.newInstance();
        //获取本类公有方法及继承的公有方法
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        System.out.println(Arrays.toString(methods));
        for (int i =0 ; i < methods.length;i++) {
            System.out.println(methods[i]);
        }
        //调用公有方法
        Method playBasketball = clazz.getMethod("playBasketball",null);
        playBasketball.invoke(boy,null);
        Method playBasketballName =  clazz.getMethod("playBasketball",java.lang.String.class);
        playBasketballName.invoke(boy,"张鹏祥");
        System.out.println("-----------------------------------------------------------------------------------------");
        //获取本类公有、私有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        System.out.println(Arrays.toString(declaredMethods));
        for (int i = 0; i< declaredMethods.length ; i++) {
            System.out.println(declaredMethods[i]);
        }
        //公有(同上)、私有方法
        Method method = clazz.getDeclaredMethod("pickUpGirl");
        method.setAccessible(true);
        method.invoke(boy);
        Method pickUpGirl = clazz.getDeclaredMethod("pickUpGirl",java.lang.String.class);
        pickUpGirl.setAccessible(true);
        pickUpGirl.invoke(boy,"张鹏祥");
        //静态方法的调用
        Method staticPlayBasketball = clazz.getMethod("playBasketball");
        staticPlayBasketball.invoke(null);
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    public static void constructorOper() throws Exception{
        Class clazz = Boy.class;
        Boy boy = (Boy) clazz.newInstance();
        //获取公有构造器
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("公有构造器的个数：" + constructors.length);
        System.out.println("公有、私有构造器列表：" + Arrays.toString(constructors));
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }
        //获取类中公共无参数构造函数
        Constructor constructor = clazz.getConstructor();
        constructor.newInstance();
        //获取类中公共两个参数的构造函数
        Constructor twoConstructor = clazz.getConstructor(int.class,int.class);
        twoConstructor.setAccessible(true);
        twoConstructor.newInstance(1,1);
        System.out.println("-----------------------------------------------------------------------------------------");
        //获取类中公有、私有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println("公有、私有构造器个数：" + declaredConstructors.length);
        System.out.println("公有、私有构造器列表平：" + Arrays.toString(declaredConstructors));
        for (int i = 0; i < declaredConstructors.length ; i++) {
            System.out.println(declaredConstructors[i]);
        }
        //调用私有的一个参数的构造函数
        Constructor prConstructor = clazz.getDeclaredConstructor(int.class);
        prConstructor.setAccessible(true);
        prConstructor.newInstance(1);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
