package com.pykj.example;

import com.pykj.example.entity.Student;
import com.pykj.example.ioc.ApplicationContext;
import com.pykj.example.ioc.ClassPathXmlApplicationContext;

public class IocTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student);

    }

}
