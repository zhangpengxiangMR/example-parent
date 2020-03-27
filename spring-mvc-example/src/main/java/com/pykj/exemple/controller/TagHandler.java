package com.pykj.exemple.controller;

import com.pykj.exemple.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tag")
public class TagHandler {

    @GetMapping("/get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("tag");
        Student student = new Student(1L,"张三",18);
        modelAndView.addObject("student",student);
        return modelAndView;
    }

}
