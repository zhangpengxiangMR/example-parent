package com.pykj.exemple.controller;

import com.pykj.exemple.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/converter")
public class ConverterHandler {

    @RequestMapping("/date")
    public String date(Date date){
        return date.toString();
    }

    @RequestMapping("/student")
    public String student(Student student){
        return student.toString();
    }

}
