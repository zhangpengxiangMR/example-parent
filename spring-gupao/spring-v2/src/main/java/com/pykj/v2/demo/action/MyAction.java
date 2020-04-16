package com.pykj.v2.demo.action;

import com.pykj.v2.demo.service.IModifyService;
import com.pykj.v2.demo.service.IQueryService;
import com.pykj.v2.spring.framework.annotation.PYAutowired;
import com.pykj.v2.spring.framework.annotation.PYController;
import com.pykj.v2.spring.framework.annotation.PYRequestMapping;
import com.pykj.v2.spring.framework.annotation.PYRequestParam;
import com.pykj.v2.spring.framework.webmvc.servlet.PYModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 公布接口url
 * @author Tom
 *
 */
@PYController
@PYRequestMapping("/web")
public class MyAction {

	@PYAutowired
	IQueryService queryService;
	@PYAutowired
	IModifyService modifyService;

	@PYRequestMapping("/query.json")
	public PYModelAndView query(HttpServletRequest request, HttpServletResponse response,
								@PYRequestParam("name") String name){
		String result = queryService.query(name);
		return out(response,result);
	}
	
	@PYRequestMapping("/add*.json")
	public PYModelAndView add(HttpServletRequest request,HttpServletResponse response,
			   @PYRequestParam("name") String name,@PYRequestParam("addr") String addr){
		String result = modifyService.add(name,addr);
		return out(response,result);
	}
	
	@PYRequestMapping("/remove.json")
	public PYModelAndView remove(HttpServletRequest request,HttpServletResponse response,
		   @PYRequestParam("id") Integer id){
		String result = modifyService.remove(id);
		return out(response,result);
	}
	
	@PYRequestMapping("/edit.json")
	public PYModelAndView edit(HttpServletRequest request,HttpServletResponse response,
			@PYRequestParam("id") Integer id,
			@PYRequestParam("name") String name){
		String result = modifyService.edit(id,name);
		return out(response,result);
	}
	
	
	
	private PYModelAndView out(HttpServletResponse resp,String str){
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
