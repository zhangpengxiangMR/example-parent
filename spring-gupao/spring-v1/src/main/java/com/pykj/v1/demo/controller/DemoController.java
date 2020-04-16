package com.pykj.v1.demo.controller;

import com.pykj.v1.mvcframework.annotation.PYAutowired;
import com.pykj.v1.mvcframework.annotation.PYController;
import com.pykj.v1.mvcframework.annotation.PYRequestMapping;
import com.pykj.v1.mvcframework.annotation.PYRequestParam;
import com.pykj.v1.demo.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@PYController
@PYRequestMapping("/demo")
public class DemoController {

  	@PYAutowired
	private IDemoService demoService;

	@PYRequestMapping("/query")
	public void query(HttpServletRequest req, HttpServletResponse resp,
					  @PYRequestParam("name") String name){
		String result = demoService.get(name);
//		String result = "My name is " + name;
		try {
			resp.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PYRequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@PYRequestParam("a") Integer a, @PYRequestParam("b") Integer b){
		try {
			resp.getWriter().write(a + "+" + b + "=" + (a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PYRequestMapping("/sub")
	public void add(HttpServletRequest req, HttpServletResponse resp,
					@PYRequestParam("a") Double a, @PYRequestParam("b") Double b){
		try {
			resp.getWriter().write(a + "-" + b + "=" + (a - b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PYRequestMapping("/remove")
	public String  remove(@PYRequestParam("id") Integer id){
		return "" + id;
	}

}
