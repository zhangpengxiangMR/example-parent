package com.pykj.springmvc.controller;

import com.pykj.springmvc.entity.Account;
import com.pykj.springmvc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/validator")
public class ValidatorHandler {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account",new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated Account account, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           return "login";
       }
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("person",new Person());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid Person person,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        return "index";
    }

}
