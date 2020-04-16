package com.pykj.springmvc.converter;

import com.pykj.springmvc.entity.Student;
import org.springframework.core.convert.converter.Converter;

public class StudentConverter implements Converter<String, Student> {
    public Student convert(String s) {
        String[] str = s.split("-");
        Student student = new Student();
        student.setId(Long.parseLong(str[0]));
        student.setName(str[1]);
        student.setAge(Integer.parseInt(str[2]));
        return student;
    }
}
