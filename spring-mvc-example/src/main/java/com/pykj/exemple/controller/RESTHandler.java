package com.pykj.exemple.controller;

import com.pykj.exemple.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RESTHandler {

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return null;
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return null;
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){

    }

}
