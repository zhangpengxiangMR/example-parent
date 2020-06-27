package com.pykj.springmvc.controller;

import com.pykj.springmvc.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class ViewHandler {

    @RequestMapping("/map")
    public String map(Map<String, Users> map) {
        Users users = new Users();
        users.setId(1);
        users.setName("map");
        map.put("users", users);
        return "view";
    }

    @RequestMapping("/model")
    public String map(Model model) {
        Users users = new Users();
        users.setId(2);
        users.setName("model");
        model.addAttribute("users", users);
        return "view";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        Users users = new Users();
        users.setId(3);
        users.setName("modelAndView");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(users);
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2() {
        Users users = new Users();
        users.setId(4);
        users.setName("modelAndView2");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(users);
        View view = new InternalResourceView("/view.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndView3")
    public ModelAndView modelAndView3() {
        Users users = new Users();
        users.setId(5);
        users.setName("modelAndView3");
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject(users);
        return modelAndView;
    }

    @RequestMapping("/modelAndView4")
    public ModelAndView modelAndView4() {
        Users users = new Users();
        users.setId(6);
        users.setName("modelAndView4");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject(users);
        return modelAndView;
    }

    @RequestMapping("/modelAndView5")
    public ModelAndView modelAndView5() {
        Users users = new Users();
        users.setId(7);
        users.setName("modelAndView5");
        Map<String, Users> usersMap = new HashMap<String, Users>();
        usersMap.put("users", users);
        ModelAndView modelAndView = new ModelAndView("view", usersMap);
        return modelAndView;
    }

    @RequestMapping("/modelAndView6")
    public ModelAndView modelAndView6() {
        Users users = new Users();
        users.setId(8);
        users.setName("modelAndView6");
        Map<String, Users> usersMap = new HashMap<String, Users>();
        usersMap.put("users", users);
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view, usersMap);
        return modelAndView;
    }

    @RequestMapping("/modelAndView7")
    public ModelAndView modelAndView7() {
        Users users = new Users();
        users.setId(9);
        users.setName("modelAndView7");
        ModelAndView modelAndView = new ModelAndView("view", "users", users);
        return modelAndView;
    }

    @RequestMapping("/modelAndView8")
    public ModelAndView modelAndView8() {
        Users users = new Users();
        users.setId(10);
        users.setName("modelAndView8");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view, "users", users);
        return modelAndView;
    }

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        Users users = new Users();
        users.setId(11);
        users.setName("request");
        request.setAttribute("users", users);
        return "view";
    }

    @ModelAttribute
    public Users getUsers() {
        Users users = new Users();
        users.setId(12);
        users.setName("getUsers");
        return users;
    }

    @RequestMapping("/modelAndView1")
    public String modelAndView1() {
        return "view";
    }

    @RequestMapping("/session")
    public String session(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Users users = new Users();
        users.setId(13);
        users.setName("session");
        httpSession.setAttribute("users", users);
        return "view";
    }

    @RequestMapping("/session2")
    public String session(HttpSession httpSession) {
        Users users = new Users();
        users.setId(14);
        users.setName("session2");
        httpSession.setAttribute("users", users);
        return "view";
    }

    @RequestMapping("/serlvetContext")
    public String application(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        Users users = new Users();
        users.setId(15);
        users.setName("serlvetContext");
        servletContext.setAttribute("users", users);
        return "view";
    }
}
