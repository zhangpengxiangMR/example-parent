package com.pykj.v2.demo.action;

import com.pykj.v2.demo.service.IQueryService;
import com.pykj.v2.spring.framework.annotation.PYAutowired;
import com.pykj.v2.spring.framework.annotation.PYController;
import com.pykj.v2.spring.framework.annotation.PYRequestMapping;
import com.pykj.v2.spring.framework.annotation.PYRequestParam;
import com.pykj.v2.spring.framework.webmvc.servlet.PYModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 公布接口url
 * @author Tom
 *
 */
@PYController
@PYRequestMapping("/")
public class PageAction {

    @PYAutowired
    IQueryService queryService;

    @PYRequestMapping("/first.html")
    public PYModelAndView query(@PYRequestParam("teacher") String teacher, @PYRequestParam("da") String da){
        String result = queryService.query(teacher);
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("teacher", teacher);
        model.put("data", result);
        model.put("token", "123456");
        return new PYModelAndView("first.html",model);
    }

}
