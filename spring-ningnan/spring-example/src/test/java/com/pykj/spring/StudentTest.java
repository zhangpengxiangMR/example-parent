package com.pykj.spring;

import com.pykj.spring.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

    public static void main(String[] args) {
       /* Student student = new Student();
        student.setId(1L);
        student.setName("张三");
        student.setAge(18);
        System.out.println(student);*/

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);

    }

}
