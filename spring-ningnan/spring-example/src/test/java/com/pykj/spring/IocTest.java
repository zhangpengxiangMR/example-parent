package com.pykj.spring;

import com.pykj.spring.entity.Student;
import com.pykj.spring.ioc.ApplicationContext;
import com.pykj.spring.ioc.ClassPathXmlApplicationContext;

public class IocTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);

    }

}
